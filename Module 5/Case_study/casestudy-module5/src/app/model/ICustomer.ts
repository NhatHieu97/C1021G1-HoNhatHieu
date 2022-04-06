import {ICustomerType} from './ICustomerType';

export interface ICustomer {
  id: number;
  name: string;
  dateOfBirth: string;
  idCard: string;
  phoneNumber: string;
  email: string;
  address: string;
  customerType: ICustomerType;
}
