import { Component, OnInit } from '@angular/core';
import {Contract} from "../model/Contract";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {SignatureCanvasComponent} from "../signature-canvas/signature-canvas.component";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.scss']
})
export class ContractListComponent implements OnInit {

  contracts: Contract[] = [
    {id: "CONTRACT-1", name: "CONTRACT-1"},
    {id: "CONTRACT-2", name: "CONTRACT-2"}
    ];

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  onSignClicked(contract: Contract) {
    const modalRef = this.modalService.open(SignatureCanvasComponent);
    modalRef.componentInstance.contract = contract;
  }
}
