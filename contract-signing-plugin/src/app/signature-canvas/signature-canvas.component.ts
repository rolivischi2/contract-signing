import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import SignaturePad from 'signature_pad';
import {Contract} from "../model/Contract";
import {SignatureService} from "../signature.service";

@Component({
  selector: 'app-signature-canvas',
  templateUrl: './signature-canvas.component.html',
  styleUrls: ['./signature-canvas.component.scss']
})
export class SignatureCanvasComponent implements OnInit, AfterViewInit {
  @ViewChild('sPad', {static: true}) signaturePadElement: { nativeElement: HTMLCanvasElement; } | undefined;
  signaturePad: any;

  @Input() contract: Contract | undefined;


  constructor(private signatureService: SignatureService) {}

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    // @ts-ignore
    this.signaturePad = new SignaturePad(this.signaturePadElement.nativeElement, {
      backgroundColor: '#ffffff'
    });
  }

  clear() {
    this.signaturePad.clear();
  }

  undo() {
    const data = this.signaturePad.toData();
    if (data) {
      data.pop(); // remove the last dot or line
      this.signaturePad.fromData(data);
    }
  }


  dataURLToBlob(dataURL: string) {
    // Code taken from https://github.com/ebidel/filer.js
    const parts = dataURL.split(';base64,');
    const contentType = parts[0].split(':')[1];
    const raw = window.atob(parts[1]);
    const rawLength = raw.length;
    const uInt8Array = new Uint8Array(rawLength);
    for (let i = 0; i < rawLength; ++i) {
      uInt8Array[i] = raw.charCodeAt(i);
    }
    return new Blob([uInt8Array], { type: contentType });
  }

  saveSignature(): void {
    if (this.signaturePad.isEmpty()) {
      alert('Please provide a signature first.');
      return;
    } else {
      const dataURL = this.signaturePad.toDataURL();
      // @ts-ignore
      this.signatureService.signContract(this.contract.id ,new File([this.dataURLToBlob(dataURL)], "signature.png")).subscribe();
    }
  }
}
