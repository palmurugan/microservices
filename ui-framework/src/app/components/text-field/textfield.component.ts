import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'text-field',
  templateUrl: './textfield.component.html',
  styleUrls: ['textfield.component.css']
})
export class TextFieldComponent implements OnInit {

 // @Input() name: string;
  @Input() placeholder: string;

  ngOnInit() {
    console.log('started');
  }
}