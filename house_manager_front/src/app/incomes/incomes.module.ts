import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChartModule } from 'primeng/chart';
import { IncomesDashboardComponent } from './incomes-dashboard/incomes-dashboard.component';
import { IncomesRoutingModule } from './incomes-routing.module';
import { CardModule } from 'primeng/card';
import { TableModule } from 'primeng/table';



@NgModule({
    declarations: [
        IncomesDashboardComponent
    ],
    imports: [
        CommonModule,
        IncomesRoutingModule,
        ChartModule,
        CardModule,
        TableModule,
    ]
})
export class IncomesModule { }
