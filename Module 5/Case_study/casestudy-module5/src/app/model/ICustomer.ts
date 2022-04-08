import {ICustomerType} from './ICustomerType';

export interface ICustomer {
  id: number;
  code: string;
  name: string;
  dateOfBirth: string;
  idCard: string;
  phoneNumber: string;
  email: string;
  address: string;
  customerType: ICustomerType;
}
