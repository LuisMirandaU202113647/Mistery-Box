import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Box } from '../modelo/box';

@Injectable({
  providedIn: 'root'
})
export class MysteryService {
  basePath = environment.basePath;

  constructor(private http: HttpClient) {}

  getMysteryBoxes() {
    return this.http.get<Box[]>(this.basePath);
  }

  getMysteryBoxId(id: any) {
    return this.http.get<Box>(`${this.basePath}/${id}`);
  }

  addMysteryBox(employee: Box) {
    return this.http.post<Box>(this.basePath, employee);
  }

  updateMysterBox(id: any, employee: Box) {
    return this.http.put<Box>(`${this.basePath}/${id}`, employee);
  }

  delete(id: any) {
    return this.http.delete<Box>(`${this.basePath}/${id}`);
  }
}
