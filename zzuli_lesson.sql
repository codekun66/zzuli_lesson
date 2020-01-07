/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : zzuli_lesson
Target Host     : localhost:3306
Target Database : zzuli_lesson
Date: 2020-01-07 16:46:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for less_chapter
-- ----------------------------
DROP TABLE IF EXISTS `less_chapter`;
CREATE TABLE `less_chapter` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `less_id` int(10) NOT NULL COMMENT '对应课程id',
  `chapter_name` varchar(50) NOT NULL COMMENT '章名称',
  `chapter_intro` varchar(255) NOT NULL COMMENT '介绍章',
  `chapter_seqno` varchar(10) NOT NULL COMMENT '章序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of less_chapter
-- ----------------------------
INSERT INTO `less_chapter` VALUES ('1', '2', '第一章  课程介绍', '介绍了课程结构、要点、前置知识和开发环境', '1');
INSERT INTO `less_chapter` VALUES ('2', '2', '第二章  计算', '变量和表达式', '2');
INSERT INTO `less_chapter` VALUES ('3', '2', '第三章  判断', '分支结构', '3');
INSERT INTO `less_chapter` VALUES ('4', '10', '第一章  Web技术介绍', '1-1 Web技术的前世今生\r\n    1-2 Web应用程序工作原理探秘\r\n    1-3 JSP初识\r\n    1-4 与JSP的第一次握手\r\n    1-5 项目：登录页面实现', '1');
INSERT INTO `less_chapter` VALUES ('5', '10', '第二章  JSP常用开发环境', '2-1 JSP环境简介\r\n    2-2应用服务器简介\r\n    2-3用NetBeans进行JSP开发\r\n    2-4用Eclipse进行JSP开发\r\n    2-5用MyEclipse进行JSP开发\r\n    2-6 项目：注册页面实现', '2');
INSERT INTO `less_chapter` VALUES ('6', '10', '第三章  HTML与CSS知识', '3-1 JSP运行原理与JSP页面的基本结构\r\n    3-2 HTML基本标签\r\n    3-3列表标签及其应用实例\r\n    3-4多媒体和超链接标签及其应用实例\r\n    3-5表格标签及其应用实例\r\n    3-6表单标签及其应用实例\r\n    3-7框架标签及其应用实例\r\n    3-8 CSS知识\r\n    3-9项目：会员管理系统设计与实现', '3');
INSERT INTO `less_chapter` VALUES ('7', '3', '第一章  计算机语言概述', '计算机语言概述', '1');
INSERT INTO `less_chapter` VALUES ('8', '3', '第二章  Java语言的跨平台原理(JVM)', 'Java语言的跨平台原理(JVM)', '2');
INSERT INTO `less_chapter` VALUES ('9', '3', '第三章  Java语言(JDK&JRE)', ' Java语言(JDK&JRE)', '3');
INSERT INTO `less_chapter` VALUES ('10', '3', '第四章  Java语言(JDK的下载与安装)', 'Java语言(JDK的下载与安装)', '4');
INSERT INTO `less_chapter` VALUES ('11', '3', '第五章  Java语言(JDK中的命令行工具)', 'Java语言(JDK中的命令行工具)', '5');
INSERT INTO `less_chapter` VALUES ('12', '3', '第六章  Java语言(命令行简介)', 'Java语言(命令行简介)', '6');
INSERT INTO `less_chapter` VALUES ('13', '3', '第七章  Java语言(环境变量配置)', 'Java语言(环境变量配置)', '7');
INSERT INTO `less_chapter` VALUES ('14', '3', '第八章  Java语言(环境变量配置-技巧)', 'Java语言(环境变量配置-技巧)', '8');
INSERT INTO `less_chapter` VALUES ('15', '13', '第一章  JS学前预热课程', 'JS学前预热课程', '1');
INSERT INTO `less_chapter` VALUES ('16', '13', '第二章  JS基础教程', 'JS基础教程', '2');
INSERT INTO `less_chapter` VALUES ('17', '13', '第三章  DOM', 'DOM详讲', '3');
INSERT INTO `less_chapter` VALUES ('18', '13', '第四章  事件讲解', '事件讲解', '4');
INSERT INTO `less_chapter` VALUES ('19', '12', '第一章  Linux系统简介', 'Linux系统简介', '1');

-- ----------------------------
-- Table structure for less_section
-- ----------------------------
DROP TABLE IF EXISTS `less_section`;
CREATE TABLE `less_section` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `chapter_id` int(10) NOT NULL,
  `section_name` varchar(255) NOT NULL COMMENT '节名称',
  `section_seqno` varchar(10) NOT NULL COMMENT '序号',
  `resource_url` varchar(255) NOT NULL COMMENT '资源url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of less_section
-- ----------------------------
INSERT INTO `less_section` VALUES ('1', '1', '第一节', '1', '/video/a.mp4');
INSERT INTO `less_section` VALUES ('2', '1', '第二节', '2', '/video/a.mp4');
INSERT INTO `less_section` VALUES ('3', '2', '第一节', '1', '/video/a.mp4');
INSERT INTO `less_section` VALUES ('4', '2', '第二节', '2', '/video/a.mp4');
INSERT INTO `less_section` VALUES ('5', '7', '计算机语言概述', '1', '/video/JAVA/01.mp4');
INSERT INTO `less_section` VALUES ('6', '8', 'Java语言的跨平台原理(JVM)', '1', '/video/JAVA/02.mp4');
INSERT INTO `less_section` VALUES ('7', '9', 'JDK&JRE', '1', '/video/JAVA/03.mp4');
INSERT INTO `less_section` VALUES ('8', '10', 'JDK的下载与安装', '1', '/video/JAVA/04.mp4');
INSERT INTO `less_section` VALUES ('9', '11', 'JDK中的命令行工具', '1', '/video/JAVA/05.mp4');
INSERT INTO `less_section` VALUES ('10', '12', '命令行简介', '1', '/video/JAVA/06.mp4');
INSERT INTO `less_section` VALUES ('11', '13', '环境变量配置', '1', '/video/JAVA/07.mp4');
INSERT INTO `less_section` VALUES ('12', '14', '  环境变量配置-技巧', '1', '/video/JAVA/08.mp4');
INSERT INTO `less_section` VALUES ('13', '15', 'JS学前预热课程-1', '1', '/video/JavaScript/0-JS学前预热课程-1.mp4');
INSERT INTO `less_section` VALUES ('14', '15', 'JS学前预热课程-2', '1', '/video/JavaScript/0-JS学前预热课程-2.mp4');
INSERT INTO `less_section` VALUES ('15', '15', 'JS学前预热课程-3', '1', '/video/JavaScript/0-JS学前预热课程-3.mp4');
INSERT INTO `less_section` VALUES ('16', '15', 'JS学前预热课程-4', '1', '/video/JavaScript/0-JS学前预热课程-4.mp4');
INSERT INTO `less_section` VALUES ('17', '15', 'JS学前预热课程-5', '1', '/video/JavaScript/0-JS学前预热课程-5.mp4');
INSERT INTO `less_section` VALUES ('18', '16', 'JS基础教程1', '2', '/video/JavaScript/1-JS基础教程1.mp4');
INSERT INTO `less_section` VALUES ('19', '16', 'JS基础教程2', '2', '/video/JavaScript/1-JS基础教程2.mp4');
INSERT INTO `less_section` VALUES ('20', '16', 'JS基础教程3', '2', '/video/JavaScript/1-JS基础教程3.mp4');
INSERT INTO `less_section` VALUES ('21', '16', 'JS基础教程4', '2', '/video/JavaScript/1-JS基础教程4.mp4');
INSERT INTO `less_section` VALUES ('22', '16', 'JS基础教程5', '2', '/video/JavaScript/1-JS基础教程5.mp4');
INSERT INTO `less_section` VALUES ('23', '17', 'DOM1', '3', '/video/JavaScript/2-1-DOM-1.mp4');
INSERT INTO `less_section` VALUES ('24', '17', 'DOM2', '3', '/video/JavaScript/2-1-DOM-2.mp4');
INSERT INTO `less_section` VALUES ('25', '18', '事件详解1', '4', '/video/JavaScript/3-事件详解1.mp4');
INSERT INTO `less_section` VALUES ('26', '18', '事件详解2', '4', '/video/JavaScript/3-事件详解2.mp4');
INSERT INTO `less_section` VALUES ('27', '18', '事件详解3', '4', '/video/JavaScript/3-事件详解3.mp4');
INSERT INTO `less_section` VALUES ('28', '19', '1.1.1UNIX发展历史和发行版本', '1', '/video/Linux/1.1.1UNIX发展历史和发行版本.mp4');
INSERT INTO `less_section` VALUES ('29', '19', '1.1.2Linux发展历史和发行版本', '1', '/video/Linux/1.1.2Linux发展历史和发行版本.mp4');
INSERT INTO `less_section` VALUES ('30', '19', '1.2开源软件简介', '1', '/video/Linux/1.2开源软件简介.mp4');
INSERT INTO `less_section` VALUES ('31', '19', '1.3Linux应用领域', '1', '/video/Linux/1.3Linux应用领域.mp4');
INSERT INTO `less_section` VALUES ('32', '19', '1.4Linux学习方法', '1', '/video/Linux/1.4Linux学习方法.mp4');

-- ----------------------------
-- Table structure for less_teacher
-- ----------------------------
DROP TABLE IF EXISTS `less_teacher`;
CREATE TABLE `less_teacher` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
  `tea_num` varchar(40) NOT NULL COMMENT '师教编号',
  `tea_name` varchar(20) NOT NULL COMMENT '教师姓名',
  `tea_introduce` varchar(400) DEFAULT NULL COMMENT '教师简介',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `sort` int(4) NOT NULL COMMENT '排序',
  `valid_sts_cd` varchar(4) NOT NULL DEFAULT '' COMMENT '有效状态码0失效1有效2删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifield_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `user_id` varchar(10) DEFAULT NULL COMMENT 'userid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of less_teacher
-- ----------------------------
INSERT INTO `less_teacher` VALUES ('1', '001', '梁树军', '长期从事数据库方向的研究，对主流的数据库技术有较深入的研究，长期受聘企业数据库工程师，尤其擅长Oracle数据库技术方面。', '/img/TeacherPicture/t_p_LiangSJ.jpg', '0', '1', '2019-01-28 10:54:08', '2018-12-27 15:22:09', '2');
INSERT INTO `less_teacher` VALUES ('2', '002', '邓露娟', '邓璐娟，女，1964年11月出生，教授，硕士生导师，2004年毕业于上海大学控制理论与控制工程专业，获工学博士学位。现任郑州轻工业学院软件学院副院长。中国软件评测中心软件测试工程师、中国软件评测中心软件性能测试高级工程师、河南省科技评价专家、河南省教师资格评测委员会专家委员、河南省首届新世纪高校优秀人才、郑州市学术技术带头人。', '/img/TeacherPicture/t_p_DengLJ.jpg', '1', '1', '2019-01-28 10:54:03', '2019-01-28 10:54:07', '3');
INSERT INTO `less_teacher` VALUES ('3', '003', '张静静', '2006.09至2010.06陕西师范大学信息与计算科学专业，获理科学士学位（本科）；2010.08至2012.6中国农业大学理学院，获理学硕士学位；2012.08至2015.06中国农业大学运筹与管理专业学习，获得博士学位；2015.8至今郑州轻工业学软件学院任讲师；', '/img/TeacherPicture/t_p_ZhangJJ.jpg', '2', '1', '2019-01-28 10:59:27', '2019-01-28 10:59:36', '4');
INSERT INTO `less_teacher` VALUES ('4', '004', '李璞', '博士，讲师，就职于郑州轻工业学院软件学院，研究方向为大数据语义分析及语义计算。参与了多个国家级或省部级项目，并以第一作者在国际SCI刊物或国内一级刊物上发表了多篇学术论文。', '/img/TeacherPicture/t_p_LiP.jpg', '3', '1', '2019-01-28 11:00:12', '2019-01-28 11:00:15', '5');
INSERT INTO `less_teacher` VALUES ('5', '005', '马军霞', '马军霞，女，硕士研究生，讲师。先后获郑州轻工业学院“师德先进个人”、“三育人”先进个人、毕业生就业工作先进个人等荣誉。主持或参与校级教改项目5项，参与省级教改项目1项；指导国家级和校级大学生创新训练项目、科技活动项目10余项；指导学生参加各类国家级和省级学科竞赛并获各级奖励21项；作为主要成员参与申报和建设河南省教学质量工程1项，参编专业教材5部，其中副主编3部。', '/img/TeacherPicture/t_p_MaJX.jpg', '4', '1', '2019-01-28 11:00:17', '2019-01-28 11:01:02', '6');
INSERT INTO `less_teacher` VALUES ('6', '006', '马欢', '2000.09—2004.06   郑州轻工业学院电子信息科学与技术专业学习，获学士学位；2006.07—2008.12   华中科技大学计算机技术专业学习，获硕士学位；2004.07—2010.3    郑州轻工业学院计算机与通信工程学院任助教；2010.4—至今       郑州轻工业学院软件学院学院任讲师。', '/img/TeacherPicture/t_p_MaH.jpg', '5', '1', '2019-01-28 11:01:22', '2019-01-28 11:01:26', '7');
INSERT INTO `less_teacher` VALUES ('7', '007', '张志峰', '2003.09至2006.04西安理工大学计算机应用技术，硕士研究生；2006.06至今郑州轻工业学院软件学院任任教；清华大学出版社特邀专家。校级优秀共产党员、指导的学生参加省级和国家级程序大赛获一等奖1项、二等奖6项、三等奖9项并多次被评为“学科竞赛优秀指导老师”，培养学生开发团队，培养出一批优秀的软件开发人员。长期以来一直进行程序设计课程的改革，课程引进“项目驱动教学的模式”，课程配置多个实训项目供学生练习，培养学生项目开发能力（工程实践能力），积累学生项目开发经验。', '/img/TeacherPicture/t_p_ZhangZF.jpg', '6', '1', '2019-01-28 11:01:42', '2019-01-28 11:01:46', '8');
INSERT INTO `less_teacher` VALUES ('8', '008', '王昌海', '2005.09至2009.06   内蒙古大学信息与计算科学专业学习，获理学学士学位（本科）；2009.09至2012.06   江苏大学计算机应用技术专业学习，获工学硕士学位；2012.09至2016.12   南开大学计算机科学与技术专业攻读博士学位，获工学博士学位；2017.06至 今郑州轻工业学院软件学院任讲师。', '/img/TeacherPicture/t_p_WangCH.jpg', '7', '1', '2019-01-28 11:02:03', '2019-01-28 11:02:05', '9');
INSERT INTO `less_teacher` VALUES ('9', '009', '崔建涛', '参加工作以来一直从事计算机网络方向的教学与研究工作。近五年来，在国内外重要的学术期刊发表论文6篇；主编、参编著作3部，自编实验讲义2部；参与2项省厅级科研（教研）项目，并通过省级鉴定，获省级以上科技奖励1项，省级优秀教学成果奖1项，获省信息技术教育优秀成果奖一等奖1项；主持、参与多项校级教学改革项目并通过鉴定。', '/img/TeacherPicture/t_p_CuiJT.jpg', '8', '1', '2019-01-28 11:02:20', '2019-01-28 11:02:23', '10');
INSERT INTO `less_teacher` VALUES ('10', '010', '曹洁', '2000.09至2004.07   安阳师范学院数学与应用数学专业学习，获理学学士学位；2008.092010.7    上海海事大学计算机应用技术专业学习，获工学硕士学位；2010.09至2015.09   同济大学计算机软件与理论专业攻读博士学位，获工学博士学位；2015.10至今         郑州轻工业学院软件学院任教。', '/img/TeacherPicture/t_p_CaoJ.jpg', '9', '1', '2019-01-28 11:02:39', '2019-01-28 11:02:42', '11');

-- ----------------------------
-- Table structure for lessons
-- ----------------------------
DROP TABLE IF EXISTS `lessons`;
CREATE TABLE `lessons` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `less_pic_url` varchar(40) DEFAULT NULL COMMENT '图片地址',
  `less_name` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `rank` varchar(10) DEFAULT NULL COMMENT '程课级别 入门、进阶',
  `tea_name` varchar(10) DEFAULT NULL COMMENT '教师名字',
  `pageview` bigint(10) DEFAULT NULL COMMENT '访问量',
  `summary` varchar(300) DEFAULT NULL COMMENT '课程简介',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifield_time` datetime DEFAULT NULL COMMENT '修改时间',
  `less_category` varchar(10) DEFAULT NULL COMMENT '课程分类',
  `valid_sts_cd` varchar(10) DEFAULT NULL COMMENT '课程有效状态码  1有效 2删除 ',
  `tea_id` varchar(10) NOT NULL,
  `required` varchar(20) NOT NULL COMMENT '是否必修  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lessons
-- ----------------------------
INSERT INTO `lessons` VALUES ('2', '/img/LessonPicture/l_p_C.png', 'C语言', '入门', '邓露娟', '310', '本C语言教程从以下几个模块来贯穿主要知识点：初始C程序、数据类型、运算符、语句结构、函数和数组。每个阶段都配有练习题同时提供在线编程任务。希望通过本教程帮助C语言入门学习者迅速掌握程序逻辑并开始C语言编程。', '2019-01-03 16:23:24', null, '编程语言', '1', '2', '必修课程');
INSERT INTO `lessons` VALUES ('3', '/img/LessonPicture/l_p_Java.png', 'Java技术', '中级', '马军霞', '97', 'Java是一种优秀的面向对象的语言，具有跨平台性、用途广泛、容易学习等特点，众多的开源项目都是用Java实现的，可以说Java是程序设计必学的语言。这门课程掌握Java语言、面向对象的特点，掌握Java在多线程、图形用户界面、网络等方面的应用，同时要养成良好的编程习惯，能够编写有一定规模的应用程序。', '2019-01-03 16:23:24', null, '编程语言', '1', '5', '必修课程');
INSERT INTO `lessons` VALUES ('6', '/img/LessonPicture/l_p_Oracle.png', 'Oracle数据库技术', '入门', '梁树军', '14', '本系列课程将向学员全面介绍数据服务器技术。课程将涉及到关系数据库和对象数据库的概念以及功 能强大的SQL编程语言，Oracle数据库体系结构、如何设计、创建、管理数据库。执行数据库管理（DBA）任务所必需的各种命令及实用程序。学习和熟悉网络概念和配置参数，以及如何解决一些常见的网络问题。从而使数据库客户机和工具都能实现与Oracle数据库服务器之间的通信。各种不同的备份、故障、复原及恢复情况。', '2019-01-03 16:23:24', '2019-01-03 16:23:24', '网络与运维', '1', '1', '必修课程');
INSERT INTO `lessons` VALUES ('10', '/img/LessonPicture/l_p_Jsp.png', 'JSP技术', '入门', '李璞', '6', '《JSP程序设计技术》课程是高等院校软件工程等专业的核心课程，着重培养学生进行动态Web应用开发的能力，具有很强的实践性和实际应用价值。本课程以项目为驱动开展教学活动，通过大量实训案例介绍JSP的开发环境搭建、基本语法、核心组件等知识和技术，既有理论，又有编程实践，通过将JSP程序设计的基本知识与过程性知识、基本理论和开发实践有机地整合，并借助若干小案例、中型项目、大型项目强化实践操作，使学生在深入理解Java Web开发思想，熟悉开发流程，切实掌握基本理论知识的基础上，提高综合应用能力和解决复杂工程问题的能力。使学生为Java Web应用开发实战打下坚实基础。', '2019-01-03 16:28:11', '2019-01-03 16:28:11', '后端开发', '1', '4', '必修课程');
INSERT INTO `lessons` VALUES ('11', '/img/LessonPicture/l_p_Database.png', '数据库原理基础', '入门', '张静静', '10', '本课程是计算机类专业的一门重要的专业基础课。数据库技术是近年来计算机应用学科中一个非常活跃、发展迅速、应用广泛的领域，越来越受到人们的关注。通过该课程的学习，可为数据库的研究和应用奠定理论基础。本课程是一门理论与实践紧密结合、实用性强的计算机软件类专业基础课，它的任务是使学生理解数据库的基本理论、数据库的组织和结构，掌握数据库系统的设计和开发方法，了解当前数据库的最新技术及最新发展。本课程主要介绍数据库系统的基本概念、原理和理论。', '2019-01-03 16:33:25', '2019-01-03 16:33:25', '专业基础课程', '1', '3', '必修课程');
INSERT INTO `lessons` VALUES ('12', '/img/LessonPicture/l_p_Linux.png', 'Linux', '入门', '师夏阳', '9', '本课程采用理论与实践相结合的方式，选取具有代表性并且有着广泛实际应用的操作系统——Linux作为基础，对Linux下应用程序的设计思想、开发特点、开发手段进行介绍，锻炼学生在Linux下设计和开发原生应用程序的实践能力。本课程对Linux下应用程序的设计思想、开发特点、开发手段进行介绍，并重点讲述文件I/O、目录操作、进程控制、线程控制、多任务同步与通信等POSIX API的使用方法和编程技巧。', '2019-01-03 16:33:56', '2019-01-03 16:33:56', '专业选修课程', '1', '0', '必修课程');
INSERT INTO `lessons` VALUES ('13', '/img/LessonPicture/l_p_JavaScript.png', 'JavaScript', '入门', '马欢', '29', '从零开始带你学习javascript，授课过程中采用手写代码+笔记的形式带你由浅入深的学习这门技术，当然也希望各位学习此视频的同学能够多动手练习，勤写笔记这样您才能更好的掌握这门技术!', '2019-01-10 15:40:23', '2019-01-10 15:40:23', '专业基础课程', '1', '6', '必修课程');
INSERT INTO `lessons` VALUES ('14', '/img/LessonPicture/l_p_JavaWEB.png', 'JavaWEB', '入门', '张志峰', '4', '涵盖 JavaWEB 企业级开发所需全部核心技术：Servlet、JSP、Filter、Listener、自定义标签、EL、JSTL、MVC 设计模式、HttpSession、Cookie、JavaBean、文件的上传下载、国际化等。', '2019-01-03 16:23:24', null, '专业基础课程', '1', '7', '必修课程');
INSERT INTO `lessons` VALUES ('15', '/img/LessonPicture/l_p_Android.png', 'Android', '入门', '王昌海', '3', '熟练掌握相机、图片、视频、Android Framework和ffmpeg、JNI/NDK等技术融入实际项目中，并熟悉后期项目的热更新、加固方式和优化，以及第三方直播平台和第三方支付接入。最终达到Android资深开发工程师标准。', '2019-01-03 16:23:24', null, '专业基础课程', '1', '8', '必修课程');
INSERT INTO `lessons` VALUES ('16', '/img/l_p_ComputerInternet.png', '计算机网络', '入门', '崔建涛', '6', '计算机网络基础知识、计算机网络设备与传输介质、计算机网络参考模型、eNSP及VRP基础、交换机的工作原理与配置、IP地址及其应用、网络层协议与应用、静态路由、企业Internet接入、WLAN的部署与安全、虚拟局域网VLAN、Eth-Trunk。', '2019-01-03 16:23:24', null, '专业基础课程', '1', '9', '必修课程');
INSERT INTO `lessons` VALUES ('17', '/img/LessonPicture/l_p_BigData.png', '大数据', '入门', '曹洁', '1', '入门级大数据精品课程，适合初学者，完备的课程在线服务体系，可以帮助初学者实现“零基础”学习大数据。课程指导思想是“构建知识体系、阐明基本原理、引导初级实践、了解相关应用”。', '2019-01-15 16:47:21', '2019-01-15 16:47:21', '专业选修课程', '1', '10', '必修课程');
INSERT INTO `lessons` VALUES ('18', '/img/LessonPicture/l_p_Cloud.png', '云计算', '入门', '曹洁', '0', '云计算是分布式计算、并行计算、效用计算、 网络存储、虚拟化、负载均衡等传统计算机和网络技术发展融合的产物。 我们身处云计算和大数据时代，已经在“云”端学习与生活。为了系统学习云计算技术，请加入“云计算技术与应用”课程吧！我们将带领你进入云中开启云计算之旅！', '2019-01-03 16:23:24', null, '专业选修课程', '1', '10', '必修课程');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'administrator');
INSERT INTO `role` VALUES ('2', 'teacher');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `role_id` varchar(10) NOT NULL COMMENT '角色id',
  `tea_name` varchar(10) NOT NULL COMMENT '教师姓名',
  `create_time` datetime DEFAULT NULL,
  `modifield_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', '管理员', null, null);
INSERT INTO `user` VALUES ('2', 'd2012019', '123456', '2', '梁树军', null, null);
INSERT INTO `user` VALUES ('3', 'teacher1', '123456', '2', '邓露娟', null, null);
INSERT INTO `user` VALUES ('4', 'teacher2', '123456', '2', '张静静', null, null);
INSERT INTO `user` VALUES ('5', 'teacher3', '123456', '2', '李璞', null, null);
INSERT INTO `user` VALUES ('6', 'teacher4', '123456', '2', '马军霞', null, null);
INSERT INTO `user` VALUES ('7', 'teacher5', '123456', '2', '马欢', null, null);
INSERT INTO `user` VALUES ('8', 'teacher6', '123456', '2', '张志峰', null, null);
INSERT INTO `user` VALUES ('9', 'teacher7', '123456', '2', '王昌海', null, null);
INSERT INTO `user` VALUES ('10', 'teacher8', '123456', '2', '崔建涛', null, null);
INSERT INTO `user` VALUES ('11', 'teacher9', '123456', '2', '曹洁', null, null);
INSERT INTO `user` VALUES ('13', '许坤', '123456', '2', '1234', '2019-03-05 16:00:45', '2019-03-05 16:00:45');
