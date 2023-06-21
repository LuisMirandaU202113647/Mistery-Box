import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Box } from 'src/app/modelo/box';
import { MysteryService } from '../services/mystery.service';

@Component({
  selector: 'app-edit-mystery',
  templateUrl: './edit-mystery.component.html',
  styleUrls: ['./edit-mystery.component.scss']
})
export class EditMysteryComponent {
  myForm!: FormGroup;
  mysteryBox!: Box;
  idMysteryBox: any;
  constructor(
    private fb: FormBuilder,
    private mysteryService: MysteryService,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.idMysteryBox = this.route.snapshot.paramMap.get('id');
    this.mysteryService.getMysteryBoxId(this.idMysteryBox).subscribe((data) => {
      this.mysteryBox = data;
      console.log(data);
      this.myForm = this.fb.group({
        id: ['this.worker.id', [Validators.required]],
        nombre: ['this.worker.nombre', [Validators.required]],
        descripcion: ['this.worker.descripcion', [Validators.required]],
        fecha: ['this.worker.fecha', [Validators.required]],
        estrellas: ['this.worker.estrellas', [Validators.required]],
        supermercado: ['this.worker.supermercado', [Validators.required]],
        stock: ['this.worker.stock', [Validators.required]],
        precio: ['this.worker.precio', [Validators.required]]
      });
    });
  }

}
