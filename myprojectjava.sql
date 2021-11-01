Create Table Client_details
( 
Client_Id int identity(1001,1), 
Name Varchar(100), 
Client_Address varchar(300),
Phone varchar(10) check(phone like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
Email varchar(100)
Primary key(Client_Id)
 );

 select * from Client_details order by Client_ID desc
 select Client_Id,Name from Client_details
 select Project_id  from Project_details where P_client=1001

 Create table Project_details
 (
	Project_id int identity(100,1),
	P_titel varchar(200),
	P_language Varchar(100),
	P_duration int,
	P_Date datetime default(getdate()),
	P_client int,
	P_cost money,
	P_discription varchar(1000)
	Primary key(Project_id)
	);
 
 select * from Project_details
 delete from Project_details where Project_id<105
 Create table Employee_details 
 (
	Emp_id int identity(200,1),
	E_name varchar(100),
	E_address varchar(200),
	E_phone Varchar(10) check(E_phone like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	E_Email varchar(100),
	E_Qualification varchar(100),
	E_Language varchar(200),
	E_post varchar(100)

	primary key (Emp_id)

 )select * from Progress_details

 select * from Employee_details 




 select count(*) from Client_details
 select * from user_detail


 Create  Table Assign_Project
( 
Ass_Id int identity(1001,1),
Emp_Id int, 
Project_Id int,
Remarks varchar(100) 
 );
 select * from Assign_Project;
 insert into Assign_Project values(121,123,'jashfjhdjhfjk');
 delete from Assign_Project where Ass_Id=1001;

 drop table Assign_Project;


 alter table Project_details add Progress Varchar(20) default('Pending');
 select *from  Project_details


 update  Project_details set Progress='Pending' where Project_id<105;

 create table Progress_details (id int identity (1,1),Emp_id int,Project_id int,Pstatus varchar(1000));


 select * from Progress_details

 select a.p_titel,b.Pstatus from Project_details a join (select * from Progress_details where Emp_id=202) b on a.Project_id=b.Project_id;


 
 insert into Progress_details values(202,102,'sjhdkaskhbbcbsdhbhbh');

 delete from Progress_details where id=1 
 select * from Assign_project;
 Delete from Assign_project where 1=1;

 delete from Progress_details where (Project_id like 103) AND (Emp_id like 202)

 alter procedure for_assign_project @pid int ,@eid int ,@remarks Varchar (100),@ret int output
 as
 begin 
 if not exists(select * from assign_project where Emp_id=@eid and Project_id=@pid) 
 begin
 Update Project_details set Progress='Running' where Project_id=@pid
 insert into Assign_project(Emp_Id,Project_Id,Remarks) values(@eid,@pid,@remarks)
 set @ret=1
 end
 else
 begin
 set @ret=0
 end
 return @ret
 end

 declare @ret int
 exec for_assign_project 25 ,39,'safjhdsjahk',@ret output
 select @ret

 select*from assign_project

 delete from assign_project where ass_id>1019

 Create Table Billing_details
 (
	InvoiceID int Identity(3001,1),
	ClientID int,
	ProjectId int,
	TotalCost money,
	BillDate datetime default(getdate()),
	Paid money,
	Balance money,
	Primary key (InvoiceID)
 );

  select * from Billing_details where ProjectID=102 and ClientID=101  order by InvoiceID desc

select a.P_cost,b.Balance from (select * from Project_details where Project_id=102 and P_client=101)a 
Join (Select top 1 * from Billing_details where ProjectID=102 and ClientID=101 )b on a.Project_id=b.ProjectId 

insert into Billing_details (ClientId,ProjectId,TotalCost,Paid,Balance) Values(12,121,12,12,12)

Select top 1 * from Billing_details where ClientId=1018 and ProjectId=105 order by InvoiceId desc
Select a.P_titel,b.InvoiceID,b.Totalcost,b.BillDate,b.Paid,b.Balance 
from(Select * from Project_details where Project_id=102)a join (Select top 1 * from Billing_details where
 ClientID=1001 and ProjectId=102 order by InvoiceID desc)b on a.Project_id=b.ProjectId

 select b.InvoiceId,b.ProjectId,a.p_titel,b.Billdate,b.TotalCost,b.Paid,b.Balance  from
  (select * from Billing_details where ClientID=1018 and ProjectId=105)b join Project_details a on a.Project_id=b.ProjectId

  select count(*) from Progress_details where Project_id=105 
  ////////////////////////////////////////////////////////////////////////////////




 alter Procedure for_progress_Report @pid int,@eid int, @ret int output
 as
 begin
update Progress_details set Pstatus='Finished' where Project_id=@pid and Emp_id=@eid
 if((select count(*) from Progress_details where Project_id=@pid)=(Select count(*) from Progress_details where Project_id=@pid and Pstatus='Finished'))
 begin
	delete from Assign_Project where Project_Id=@pid;
	update Project_details set Progress='Finished' where Project_id=@pid 
	delete from Progress_details where Project_id=@pid
	set @ret=1
 end
 else
 begin
 set @ret=0
 end
 return @ret
 end


declare @ret int
 exec for_progress_Report 104 ,206,@ret output
 select @ret

 
 
 select *from Progress_details

 update Progress_details set Pstatus='ashgdasgha' where 1=1

)
select a.Name,b.* ,c.P_titel ,c.Progress from Client_details a join
  ( select * from Billing_details where Balance in(0)) b on a.Client_Id=b.ClientID join
   Project_details c on c.Project_id=b.ProjectId

   select count(*) from Billing_details where Balance in(0)


 select * from Project_details where Project_id in(select Project_id from Project_details where Project_id not in (Select distinct ProjectId from Billing_details ) )
  select count(*) from Project_details where Project_id in(select Project_id from Project_details where Project_id not in (Select distinct ProjectId from Billing_details ) )

  select count (distinct ProjectId) from Billing_details where Balance not in (0)


  select  b.Name,a.* from (select * from  Project_details 
   where Project_id in(select Project_id from Project_details where
    Project_id not in (Select distinct ProjectId from Billing_details )))a
   join  Client_details b on a.P_client=b.Client_ID 
   ///////////////////////

   (select * from Billing_details where ProjectId not in 
   (select ProjectID from Billing_details where balance=0))

   ProjectId not in(select * from Billing_details where Balance=0)


   Select * ,Isnull((Select Sum(Paid) from Billing_details 
    where ProjectId not in(select * from Billing_details where Balance=0) and ClientID=Client_details.Client_Id 
   and ProjectId=Project_details.Project_id) ,0) as pai from Client_details join Project_details on 
   Client_details.Client_Id=Project_details.P_client 
   
   /////////////////////////////

   select count(*) from (select * from Project_details join Client_details on Project_details.P_client=Client_details.Client_Id join Billing_details on Billing_details.ProjectId=Project_details.Project_id 



   Select ProjectID,sum(paid) from Billing_details group by ProjectId 

  select count(*) from Project_details a join Assign_Project b on a.Project_Id=b.Project_id join Employee_Details c on b.Emp_id=c.Emp_id
  
   select * from Assign_Project

   delete from   Assign_Project where Project_id=103
   select * from Employee_details

   Select * from Project_details