USE master
GO
--Tạo CSDL Personel
CREATE DATABASE Personel
GO
--Chọn CSDL làm việc
USE Personel
GO
--Tạo bảng User lưu thông tin người sử dụng

If OBJECT_ID('Users') is not null
	drop table Users
go

CREATE TABLE Users(
	Username nvarchar(50) NOT NULL,
	Password nvarchar(50) NOT NULL,
	Fullname nvarchar(50) NOT NULL,
	PRIMARY KEY(Username)
)
GO
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

delete from Users


insert into Users values(N'chunghh',N'123456',N'Hà Huy Chung')
insert into Users values(N'canhtd',N'123456',N'Trần Đức Cảnh')
insert into Users values(N'huytht',N'123456',N'Trần Hoàng Tuấn Huy')
insert into Users values(N'tainv',N'123456',N'Nguyễn Văn Tài')
insert into Users values(N'dangtv',N'123456',N'Trần Văn Đăng')
insert into Users values(N'nhint',N'123456',N'Nguyễn Thị Nhi')
insert into Users values(N'hainv',N'123456',N'Nguyễn Văn Hải')
insert into Users values(N'quocpv',N'123456',N'Phạm Văn Quốc')
insert into Users values(N'hantt',N'123456',N'Nguyễn Thị Thu Hà')
insert into Users values(N'namtv',N'123456',N'Trần Văn Nam')


select * from Users

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--Tạo bảng Departs lưu thông tin phòng ban

If OBJECT_ID('Departs') is not null
	drop table Departs
go

CREATE TABLE Departs(
	Id nvarchar(10) NOT NULL,
	Name nvarchar(50) NOT NULL,
	PRIMARY KEY(Id)
)
GO
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
delete from Departs


insert into Departs values(N'KT',N'Kế Toán')
insert into Departs values(N'NS',N'Nhân Sự')

select * from Departs


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Tạo bảng Staffs lưu thông tin nhân viên

If OBJECT_ID('Staffs') is not null
	drop table Staffs
go


CREATE TABLE Staffs(
	Id nvarchar(10) NOT NULL,
	Name nvarchar(50) NOT NULL,
	Gender bit NOT NULL,
	Birthday date NOT NULL,
	Photo nvarchar(50) NOT NULL,
	Email nvarchar(50) NOT NULL,
	Phone nvarchar(25) NOT NULL,
	Salary float NOT NULL,
	Notes nvarchar(500) NULL,
	DepartId nvarchar(10) NOT NULL,
	PRIMARY KEY(Id),
	FOREIGN KEY(DepartId) REFERENCES Departs(Id) ON DELETE CASCADE ON UPDATE CASCADE
)
GO
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
delete from Staffs

insert into Staffs values(N'HHC01',N'Hà Huy Chung',0,N'1999-06-22',N'User01.jpg',N'hahuychung@gmail.com',N'01683605881',10,NULL,N'KT')
insert into Staffs values(N'TDC02',N'Trần Đức Cảnh',0,N'1999-11-08',N'User02.jpg',N'tranduccanh@gmail.com',N'01684605761',9,NULL,N'KT')
insert into Staffs values(N'THTH03',N'Trần Hoàng Tuấn Huy',0,N'1999-10-05',N'User03.jpg',N'loliisbest@gmail.com',N'01687566975',6,NULL,N'NS')
insert into Staffs values(N'NVT04',N'Nguyễn Văn Tài',0,N'1999-07-22',N'User04.jpg',N'nguyenvantai@gmail.com',N'01682105481',5,NULL,N'KT')
insert into Staffs values(N'TVD05',N'Trần Văn Đăng',0,N'1999-09-20',N'User05.jpg',N'tranvandang@gmail.com',N'01682105861',3,NULL,N'NS')
insert into Staffs values(N'NTN06',N'Nguyễn Thị Nhi',1,N'1999-01-22',N'User06.jpg',N'nguyenthinhi@gmail.com',N'01683606589',7,NULL,N'NS')
insert into Staffs values(N'NVH07',N'Nguyễn Văn Hải',0,N'1999-12-31',N'User07.jpg',N'nguyenvanhai@gmail.com',N'01683605675',2,NULL,N'KT')
insert into Staffs values(N'PVQ08',N'Phạm Văn Quốc',0,N'1999-06-13',N'User08.jpg',N'phamvanquoc@gmail.com',N'01683605331',5,NULL,N'KT')
insert into Staffs values(N'NTTH09',N'Nguyễn Thị Thu Hà',1,N'1999-06-22',N'User09.jpg',N'nguyenthithuha@gmail.com',N'01683608783',1,NULL,N'NS')
insert into Staffs values(N'TVN010',N'Trần Văn Nam',0,N'1999-01-22',N'User010.jpg',N'tranvannam@gmail.com',N'01683605654',4,NULL,N'KT')


select * from Staffs
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--Tạo bảng Records lưu thông tin thành tích và kỷ luật của nhân viên

If OBJECT_ID('Records') is not null
	drop table Records
go


CREATE TABLE Records(
	Id bigint IDENTITY(1,1) NOT NULL,
	Type int NOT NULL,
	Reason nvarchar(200) NOT NULL,
	Date date NOT NULL,
	StaffId nvarchar(10) NOT NULL,
	PRIMARY KEY(Id),
	FOREIGN KEY(StaffId) REFERENCES Staffs(Id) ON DELETE NO ACTION ON UPDATE CASCADE
 )

 GO
 -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

delete from Records

insert into Records(Type,Reason,Date,StaffId) values(1,N'Đạt tốt mục tiêu trong tháng',N'2018-10-25',N'HHC01')
insert into Records(Type,Reason,Date,StaffId) values(1,N'Đạt tốt mục tiêu trong tháng',N'2018-11-01',N'TDC02')
insert into Records(Type,Reason,Date,StaffId) values(1,N'Đạt tốt mục tiêu trong tháng',N'2018-10-22',N'THTH03')
insert into Records(Type,Reason,Date,StaffId) values(1,N'Đạt tốt mục tiêu trong tháng',N'2018-11-11',N'NVT04')
insert into Records(Type,Reason,Date,StaffId) values(0,N'Chậm Deadline',N'2018-10-07',N'TVD05')
insert into Records(Type,Reason,Date,StaffId) values(1,N'Đạt tốt mục tiêu trong tháng',N'2018-09-23',N'NTN06')
insert into Records(Type,Reason,Date,StaffId) values(0,N'Chậm Deadline',N'2018-03-25',N'NVH07')
insert into Records(Type,Reason,Date,StaffId) values(0,N'Chậm Deadline',N'2018-03-21',N'PVQ08')
insert into Records(Type,Reason,Date,StaffId) values(1,N'Đạt tốt mục tiêu trong tháng',N'2018-02-25',N'NTTH09')
insert into Records(Type,Reason,Date,StaffId) values(0,N'Chậm Deadline',N'2018-02-13',N'TVN010')

select * from Records
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------