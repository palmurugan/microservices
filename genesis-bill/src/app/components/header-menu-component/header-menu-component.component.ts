import { Component, OnInit } from '@angular/core';

import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-header-menu-component',
  templateUrl: './header-menu-component.component.html',
  styleUrls: ['./header-menu-component.component.scss']
})
export class HeaderMenuComponentComponent implements OnInit {

  private items: MenuItem[];

  constructor() { }

  ngOnInit() {
    this.items = [
      {
          label: 'Master',
          items: [
              {label: 'Product'},
              {label: 'Customer'},
              {label: 'Supplier'},
              {label: 'Unit'}
          ]
      },
      {
          label: 'Purchase',
          items: [
              {label: 'Create', icon: 'pi pi-fw pi-pencil', routerLink: ['/createpurchase']},
              {label: 'List', icon: 'pi pi-fw pi-refresh', routerLink: ['/purchase']}
          ]
      },
      {
        label: 'Sales',
        items: [
            {label: 'Create', icon: 'pi pi-fw pi-pencil'},
            {label: 'View', icon: 'pi pi-fw pi-refresh'}
        ]
    },
    {
        label: 'Receipt',
        items: [
            {label: 'Create', icon: 'pi pi-fw pi-pencil'},
            {label: 'View', icon: 'pi pi-fw pi-refresh'}
        ]
    },
    {
        label: 'Reports',
        items: [
            {label: 'Create', icon: 'pi pi-fw pi-pencil'},
            {label: 'View', icon: 'pi pi-fw pi-refresh'}
        ]
    }
  ];
  }
}
