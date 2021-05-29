import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SignatureService {

  constructor(private httpClient: HttpClient) { }

  signContract(contractId: string, file: File): Observable<HttpEvent<{}>> {
    const data: FormData = new FormData();
    data.append('file', file);
    data.append("contractId", contractId);
    const newRequest = new HttpRequest('POST', 'http://localhost:8081/signature', data, {
      reportProgress: true,
      responseType: 'text'
    });
    return this.httpClient.request(newRequest);
  }

}
