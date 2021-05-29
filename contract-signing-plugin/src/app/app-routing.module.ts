import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignatureCanvasComponent} from "./signature-canvas/signature-canvas.component";
import {ContractListComponent} from "./contract-list/contract-list.component";

const routes: Routes = [
  {path: 'signed', component: SignatureCanvasComponent},
  {path: '*', redirectTo: 'templates'},
  {path: 'templates', component: ContractListComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
