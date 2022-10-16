import { Component, OnInit } from '@angular/core';
import { Income } from '../models/income';

@Component({
  selector: 'app-incomes-dashboard',
  templateUrl: './incomes-dashboard.component.html',
  styleUrls: ['./incomes-dashboard.component.sass']
})
export class IncomesDashboardComponent implements OnInit {

    incomes: Income[] = [];

    data: any;

    basicData: any;

    chartOptions: any;

    constructor() { }

    ngOnInit(): void {
        this.incomes = [
            {
                id: 'fjn34nuub532',
                name: 'Investiments',
                amount: 34,
                date: '2022-03-04',
                origin: {
                    id: 'nfrifn',
                    name: 'Stock Exchange'
                }
            },
            {
                id: 'n899ng54n',
                name: 'Profits',
                amount: 63,
                date: '2022-03-05',
                origin: {
                    id: '4382jrj29r',
                    name: 'Business'
                }
            },
            {
                id: '43850n34fn',
                name: 'Profits',
                amount: 29,
                date: '2022-03-06',
                origin: {
                    id: 'nf934nf9n',
                    name: 'Store'
                }
            },
            {
                id: '43850n34fn',
                name: 'Profits',
                amount: 94,
                date: '2022-03-07',
                origin: {
                    id: 'nf934nf9n',
                    name: 'Virtual Store'
                }
            },
        ]
        this.data = {
            labels: ['Stock Exchange', 'Business', 'Store', 'Virtual Store'],
            datasets: [
                {
                    data: [34, 63, 29, 94],
                    backgroundColor: [
                        "#42A5F5",
                        "#66BB6A",
                        "#FFA726",
                        "#E80909"
                    ],
                    hoverBackgroundColor: [
                        "#64B5F6",
                        "#81C784",
                        "#FFB74D",
                        "#F54545"
                    ]
                }
            ]
        }
        this.basicData = {
            labels: ['March'],
            datasets: [
                {
                    label: 'Stock Exchange',
                    data: [34],
                    fill: false,
                    borderColor: '#42A5F5',
                    tension: .4
                },
                {
                    label: 'Business',
                    data: [63],
                    fill: false,
                    borderColor: '#66BB6A',
                    tension: .4
                },
                {
                    label: 'Store',
                    data: [29],
                    fill: false,
                    borderColor: '#FFA726',
                    tension: .4
                },
                {
                    label: 'Virtual Store',
                    data: [94],
                    fill: false,
                    borderColor: '#E80909',
                    tension: .4
                }
            ]
        };
    }

}
