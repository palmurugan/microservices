import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ReportRoutes } from './report/report.routes';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/report',
        pathMatch: 'full'
    },
    ...ReportRoutes
]
export const routing: ModuleWithProviders = RouterModule.forRoot(routes);