import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncomesDashboardComponent } from './incomes-dashboard.component';

describe('IncomesDashboardComponent', () => {
    let component: IncomesDashboardComponent;
    let fixture: ComponentFixture<IncomesDashboardComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [ IncomesDashboardComponent ]
        })
        .compileComponents();

        fixture = TestBed.createComponent(IncomesDashboardComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
