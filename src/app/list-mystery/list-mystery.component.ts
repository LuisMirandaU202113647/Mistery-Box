import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Box } from '../modelo/box';
import { MysteryService } from '../services/mystery.service';

@Component({
  selector: 'app-list-mystery',
  templateUrl: './list-mystery.component.html',
  styleUrls: ['./list-mystery.component.scss']
})
export class ListMysteryComponent implements OnInit {
  displayedColumns: string[] = ['id', 'nombre', 'descripcion', 'fecha', 'estrellas', 'supermercado', 'stock', 'precio'];
  dataSource = new MatTableDataSource<Box>();

  constructor(private mysteryservice: MysteryService) {}

  ngOnInit(): void {
      this.getMysteryBoxes();
  }

  getMysteryBoxes(){
    this.mysteryservice.getMysteryBoxes().subscribe((data: Box[]) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  deleteMysteryBox(id:number){
    if(confirm("¿Desea de eliminar?")){
      this.mysteryservice.delete(id).subscribe(() => {
        this.dataSource.data = this.dataSource.data.filter((e: Box) => {
          return e.id !== id ? e : false;
        });
      });
  }
    console.log(this.dataSource.data);
  }
}
