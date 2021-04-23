import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InlinePdfViewerComponent } from './inline-pdf-viewer/inline-pdf-viewer.component';

const routes: Routes = [
  {path: 'inline', component: InlinePdfViewerComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
