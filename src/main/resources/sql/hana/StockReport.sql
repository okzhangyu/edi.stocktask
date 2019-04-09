
/****** Object:  Table "dbo"."AVA_WM_OSRP"    Script Date: 2018/7/29 18:37:12 ******/

CREATE TABLE AVA_WM_OSRP(
	"CompanyName" nvarchar(20),
	"DocEntry" INTEGER NOT NULL,
	"DocNum" INTEGER NULL,
	"Period" INTEGER NULL,
	"Object" "varchar"(30) ,
	"Transfered" nvarchar(1) ,
	"CreateDate" datetime ,
	"CreateTime" INTEGER,
	"UpdateDate" datetime ,
	"UpdateTime" INTEGER ,
	"Creator" INTEGER ,
	"Updator" INTEGER ,
	"DocStatus" varchar(1),
	"DocDate" datetime,
	"DocDueDate" datetime,
	"TaxDate" datetime,
	"Ref1" nvarchar(100),
	"Ref2" nvarchar(200) ,
	"Remarks" nvarchar(200),
	"B1DocEntry" INTEGER,
	"BydUUID" nvarchar(36) ,
	"CusType" nvarchar(8) ,
	"TransType" varchar(1) ,
	"BpCode" nvarchar(20),
	"BpName" nvarchar(100),
	"BaseType" nvarchar(30),
	"BaseEntry" INTEGER);

  CREATE INDEX KAVA_WM_OSRP ON AVA_WM_OSRP("DocEntry")



/******************************************************************************************/

/****** Object:  Table "dbo"."AVA_WM_SRP1"    Script Date: 2018/7/29 18:38:02 ******/
CREATE TABLE "AVA_WM_SRP1"(
	"DocEntry" INTEGER NOT NULL,
	"LineId" INTEGER NOT NULL,
	"Object" varchar(30),
	"LineStatus" varchar(1),
	"Ref1" nvarchar(100) ,
	"Ref2" nvarchar(200) ,
	"BaseType" nvarchar(30) ,
	"BaseEntry" INTEGER ,
	"BaseLine" INTEGER,
	"Project" nvarchar(8) ,
	"OcrCode1" nvarchar(8) ,
	"OcrCode2" nvarchar(8) ,
	"OcrCode3" nvarchar(8) ,
	"OcrCode4" nvarchar(8) ,
	"OcrCode5" nvarchar(8) ,
	"BSType" nvarchar(30) ,
	"BSEntry" INTEGER ,
	"BSLine" INTEGER ,
	"TargetType" nvarchar(30) ,
	"TargetEntry" INTEGER ,
	"TargetLine" INTEGER ,
	"ItemCode" nvarchar(20) ,
	"ItemName" nvarchar(200) ,
	"Quantity" "numeric"(19, 6) ,
	"Uom" nvarchar(8) ,
	"ManSerNum" nvarchar(1) ,
	"ManBtchNum" nvarchar(1) ,
	"ManServiceNum" nvarchar(1) ,
	"Price" "numeric"(19, 6) ,
	"Currency" nvarchar(8) ,
	"Rate" decimal(19, 6) ,
	"LineTotal" "numeric"(19, 6) ,
	"FromWH" nvarchar(8) ,
	"FromLC" nvarchar(60) ,
	"ToWH" nvarchar(8) ,
	"ToLC" nvarchar(60) ,
	"BatchNum" nvarchar(30) ,
	"SerialNum" nvarchar(30) ,
	"BarCode1" nvarchar(60) ,
	"BarCode2" nvarchar(60) ,
	"BarCode3" nvarchar(60) ,
	"BarCode4" nvarchar(60)
 )

CREATE INDEX KAVA_WM_SRP1 ON AVA_WM_SRP1("DocEntry","LineId")


/******************************************************************************************/

/****** Object:  Table "dbo"."AVA_WM_SRP2"    Script Date: 2018/8/6 19:40:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE "dbo"."AVA_WM_SRP2"(
	"DocEntry" INTEGER NOT NULL,
	"LineId" INTEGER NOT NULL,
	"Object" nvarchar(50) ,
	"ItemCode" nvarchar(50) ,
	"BarCode" nvarchar(50) NOT null,
	"BatchNumber" nvarchar(50) ,
	"SerialNumber" nvarchar(50) ,
	"Quantity" decimal(19, 6))

CREATE INDEX PK_AVA_WM_SRP2 ON AVA_WM_SRP2("DocEntry","LineId","BarCode")


