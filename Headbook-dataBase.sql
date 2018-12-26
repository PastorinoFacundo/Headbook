USE [master]
GO

/****** Object:  Database [Headbook] ******/
CREATE DATABASE [Headbook]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Headbook', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\Headbook.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Headbook_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\Headbook_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO

ALTER DATABASE [Headbook] SET COMPATIBILITY_LEVEL = 140
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Headbook].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [Headbook] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [Headbook] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [Headbook] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [Headbook] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [Headbook] SET ARITHABORT OFF 
GO

ALTER DATABASE [Headbook] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [Headbook] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [Headbook] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [Headbook] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [Headbook] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [Headbook] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [Headbook] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [Headbook] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [Headbook] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [Headbook] SET  DISABLE_BROKER 
GO

ALTER DATABASE [Headbook] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [Headbook] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [Headbook] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [Headbook] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [Headbook] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [Headbook] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [Headbook] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [Headbook] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [Headbook] SET  MULTI_USER 
GO

ALTER DATABASE [Headbook] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [Headbook] SET DB_CHAINING OFF 
GO

ALTER DATABASE [Headbook] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [Headbook] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [Headbook] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [Headbook] SET QUERY_STORE = OFF
GO

ALTER DATABASE [Headbook] SET  READ_WRITE 
GO



USE [Headbook]
GO



/****** Object:  Table [dbo].[USERS] ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[USERS](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[surname] [varchar](50) NOT NULL,
	[avatar] [nvarchar](1000) NULL,
 CONSTRAINT [PK_USERS] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[USERS]  WITH CHECK ADD  CONSTRAINT [FK_USERS_USERS] FOREIGN KEY([id])
REFERENCES [dbo].[USERS] ([id])
GO

ALTER TABLE [dbo].[USERS] CHECK CONSTRAINT [FK_USERS_USERS]
GO


/****** Object:  Table [dbo].[POSTS] ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[POSTS](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[creator] [bigint] NOT NULL,
	[date] [datetime] NOT NULL,
	[title] [varchar](100) NOT NULL,
	[content] [varchar](1000) NULL,
 CONSTRAINT [PK_POSTS] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[POSTS]  WITH CHECK ADD  CONSTRAINT [FK_POSTS_USERS] FOREIGN KEY([creator])
REFERENCES [dbo].[USERS] ([id])
GO

ALTER TABLE [dbo].[POSTS] CHECK CONSTRAINT [FK_POSTS_USERS]
GO


/****** Object:  Table [dbo].[LIKES] ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[LIKES](
	[user_id] [bigint] NOT NULL,
	[post_id] [bigint] NOT NULL,
 CONSTRAINT [PK_LIKES_1] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[post_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[LIKES]  WITH CHECK ADD  CONSTRAINT [FK_LIKES_POSTS] FOREIGN KEY([post_id])
REFERENCES [dbo].[POSTS] ([id])
GO

ALTER TABLE [dbo].[LIKES] CHECK CONSTRAINT [FK_LIKES_POSTS]
GO

ALTER TABLE [dbo].[LIKES]  WITH CHECK ADD  CONSTRAINT [FK_LIKES_USERS] FOREIGN KEY([user_id])
REFERENCES [dbo].[USERS] ([id])
GO

ALTER TABLE [dbo].[LIKES] CHECK CONSTRAINT [FK_LIKES_USERS]
GO



/****** INSERTS FOR [dbo].[USERS] ******/

INSERT INTO [dbo].[USERS]
           ([name]
           ,[surname]
           ,[avatar])
     VALUES
           ('Facundo'
           ,'Pastorino'
           ,'https://www.elastic.co/assets/bltada7771f270d08f6/enhanced-buzz-1492-1379411828-15.jpg')
GO

INSERT INTO [dbo].[USERS]
           ([name]
           ,[surname]
           ,[avatar])
     VALUES
           ('José'
           ,'Perez'
           ,'https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png')
GO

INSERT INTO [dbo].[USERS]
           ([name]
           ,[surname]
           ,[avatar])
     VALUES
           ('Sara'
           ,'Pastorino'
           ,'https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png')
GO

INSERT INTO [dbo].[USERS]
           ([name]
           ,[surname]
           ,[avatar])
     VALUES
           ('Rodney'
           ,'Phillips'
           ,'https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png')
GO

INSERT INTO [dbo].[USERS]
           ([name]
           ,[surname]
           ,[avatar])
     VALUES
           ('Alberto'
           ,'Calderon'
           ,'https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png')
GO


/****** INSERTS FOR [dbo].[POSTS] ******/

DECLARE @cnt1 int = 1;
DECLARE @cnt2 int = 0;

WHILE @cnt1 < 6
BEGIN
   WHILE @cnt2 < 4
	BEGIN
	   INSERT INTO [dbo].[POSTS]
				   ([creator]
				   ,[date]
				   ,[title]
				   ,[content])
			 VALUES
				   (@cnt1
				   ,'2018-12-25 00:00:00.000'
				   ,'Lorem ipsum'
				   ,'Lorem ipsum dolor sit amet consectetur adipiscing elit euismod aptent habitant, nulla vehicula est nisl vestibulum natoque donec sem tempor, pellentesque dictum porta morbi mollis convallis dignissim cum iaculis. Vitae mollis leo ad porttitor etiam et felis purus dictum nulla fusce est vel, magnis sem parturient venenatis feugiat eget praesent viverra cubilia netus porta fames tempus rhoncus, a velit nam pulvinar molestie nec diam lacinia augue facilisi proin convallis. Non convallis hendrerit class litora velit pellentesque in luctus dictum, parturient fames eros dis tempus nisl eu posuere, ante aenean dui risus ac vestibulum suscipit curae.')
	   SET @cnt2 = @cnt2 + 1;
	END;
	SET @cnt2 = 0;
   SET @cnt1 = @cnt1 + 1;
END;
GO