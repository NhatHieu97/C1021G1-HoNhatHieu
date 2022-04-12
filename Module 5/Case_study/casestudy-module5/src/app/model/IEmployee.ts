import {IEmployeePosition} from './IEmployeePosition';
import {IEmployeeEducationDegree} from './IEmployeeEducationDegree';

export interface IEmployee {
  id? : number;
  name? : string;
  gender?: boolean;
  birthday? : string;
  idCard? : string;
  phone? : string;
  email? : string;
  address? : string;
  salary? : number;
  employeePosition? : IEmployeePosition;
  employeeEducationDegree? : IEmployeeEducationDegree;
}
