import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GlobalService } from './global.service';
import { FileData } from '../models/fileData';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private http: HttpClient, private globalService: GlobalService) { }

  private apiServerUrl = this.globalService.apiServerUrl;

  public uploadFile(fileForm: FormData): Observable<string> {
    return this.http.request('post', `${this.apiServerUrl}/file/upload`, {
      body: fileForm,
      responseType: 'text' // Set the responseType to 'text'
    });
  }

  public downloadFile(filename: string): Observable<Blob>{
    return this.http.get(`${this.apiServerUrl}/file/download/${filename}`, { responseType: 'blob' });
  }

  //get a file by its fileName
  public getFileByFileName(filename: string): Observable<FileData>{
    return this.http.get<FileData>(`${this.apiServerUrl}/file/getByFileName/${filename}`)
  }
}
