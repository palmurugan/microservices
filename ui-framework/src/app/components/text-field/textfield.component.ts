import { Component } from '@angular/core';

@Component({
  selector: 'text-field',
  templateUrl: './textfield.component.html',
  styleUrls: ['textfield.component.css']
})
export class TextFieldComponent {

  private placeholder: string = 'First Name';
  private value: string = '';
}