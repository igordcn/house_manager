import { Origin } from "./origin";

export interface Income {
    id: string;
    name: string;
    amount: number;
    date: string;
    origin: Origin;
}
