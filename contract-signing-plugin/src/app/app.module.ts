import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SignatureCanvasComponent } from './signature-canvas/signature-canvas.component';
import { InlinePdfViewerComponent } from './inline-pdf-viewer/inline-pdf-viewer.component';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { ContractListComponent } from './contract-list/contract-list.component';
import {SignatureService} from "./signature.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    SignatureCanvasComponent,
    InlinePdfViewerComponent,
    ContractListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    PdfViewerModule,
    HttpClientModule
  ],
  providers: [SignatureService],
  bootstrap: [AppComponent]
})
export class AppModule { }
