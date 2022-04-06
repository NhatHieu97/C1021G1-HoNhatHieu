import {IStudent} from '../model/IStudent';

export class StudentDao {
  public static students: IStudent[] = [{
    id: 1,
    name: 'Hồ Nhật Hiếu',
    age: 25,
    mark: 10,
    address: 'Hội An'
  },
    {
      id: 2,
      name: 'Nguyễn Văn ngọc đạt',
      age: 15,
      mark: 5,
      address: 'Huế'
    },
    {
      id: 3,
      name: 'Nguyễn Văn Linh',
      age: 25,
      mark: 6,
      address: 'Đà Nẵng'
    },
    {
      id: 4,
      name: 'Nguyễn thành long',
      age: 26,
      mark: 7,
      address: 'Đà Nẵng'
    }
  ]

}
