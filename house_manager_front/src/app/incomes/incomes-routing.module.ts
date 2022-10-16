import { NgModule } from "@angular/core";
import { Route, RouterModule } from "@angular/router";
import { IncomesDashboardComponent } from "./incomes-dashboard/incomes-dashboard.component";

const routes: Route[] = [
    {
        path: '',
        component: IncomesDashboardComponent
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class IncomesRoutingModule { }
