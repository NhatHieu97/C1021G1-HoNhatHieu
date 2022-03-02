SELECT * FROM furama_case_study.service;
insert into service(service_name,service_area,service_cost,service_max_people,standard_room,description_other_convenience,pool_area,number_of_floors,rent_type_id,service_type_id)
values("Villa Beach Front","25000",10000000,10,"vip","Có hồ bơi",500,4,3,1),
("House Princess 01","14000",5000000,7,"vip","Có thêm bếp nướng",null,3,2,2),
("Room Twin 01","5000",1000000,2,"vip","Có tivi",null,null,4,3),
("Villa No Beach Front","22000",9000000,8,"normal","Có hồ bơi",300,3,3,1),
("House Princess 02","10000",4000000,5,"normal","Có thêm bếp nướng",null,2,3,2),
("Room Twin 02","3000",900000,2,"normal","Có tivi",null,null,4,3);