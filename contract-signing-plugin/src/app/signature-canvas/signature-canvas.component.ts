import { AfterViewInit, Component, ElementRef, OnInit, QueryList, ViewChild, ViewChildren } from '@angular/core';
import SignaturePad from 'signature_pad';

@Component({
  selector: 'app-signature-canvas',
  templateUrl: './signature-canvas.component.html',
  styleUrls: ['./signature-canvas.component.scss']
})
export class SignatureCanvasComponent implements OnInit {

  
  @ViewChildren('canvas')
  canvas!: QueryList<ElementRef<HTMLCanvasElement>>;
  
  signaturePads: SignaturePad[] = [];
  pages: string[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.canvas.forEach(c => this.signaturePads.push(new SignaturePad(c.nativeElement)));
  }

  init():void {

  }

  clear() {
    this.signaturePads.forEach(p => p.clear());
  }


  // undo() {
  //   const data = this.signaturePad.toData();
  //   if (data) {
  //     data.pop(); // remove the last dot or line
  //     this.signaturePad.fromData(data);
  //   }
  // }


}
