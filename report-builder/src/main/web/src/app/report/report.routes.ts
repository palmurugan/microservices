import { Routes } from '@angular/router';

import { ReportCreateComponent } from './report-create.component';
import { ReportUpdateComponent } from './report-update.component';
import { ReportListComponent } from './report-list.component';


export const ReportRoutes: Routes = [
    { path: 'create', component: ReportCreateComponent },
    { path: 'update/:reportId', component: ReportUpdateComponent },
    { path: 'report', component: ReportListComponent }
];