/*
Navicat MySQL Data Transfer

Source Server         : xiaoxiaoguai
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : yixinyiyi

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-12-22 14:54:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('10', '1234567', 'yzx', '123456');
INSERT INTO `account` VALUES ('16', '19974712583', '颜自翔', '123456');

-- ----------------------------
-- Table structure for illness
-- ----------------------------
DROP TABLE IF EXISTS `illness`;
CREATE TABLE `illness` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `illnessname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '疾病名称',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '疾病简介',
  `feature` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '临床表现',
  `advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '建议',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of illness
-- ----------------------------
INSERT INTO `illness` VALUES ('1', '糖尿病', '糖尿病是一组以高血糖为特征的代谢性疾病。高血糖则是由于胰岛素分泌缺陷或其生物作用受损，或两者兼有引起。长期存在的高血糖，导致各种组织，特别是眼、肾、心脏、血管、神经的慢性损害、功能障碍。', '主要临床表现为：饮水量过大、多食、多尿、体重下降明显；而非典型症状表现为易疲劳，视力出现障碍等。', '目前尚无根治糖尿病的方法，但通过多种治疗手段可以控制好糖尿病。主要包括5个方面：糖尿病患者的教育，自我监测血糖，饮食治疗，运动治疗和药物治疗。', 'image/illness/tangniaobing.jpg');
INSERT INTO `illness` VALUES ('2', '痛风', '痛风是一种常见且复杂的关节炎类型，各个年龄段均可能罹患本病，男性发病率高于女性。人体内嘌呤含量越多，代谢产生的尿酸就越多，同时酒精刺激肝脏也会产生尿酸，而这会增加痛风的发病率和痛风对人体的危害。', '痛风患者经常会在夜晚出现突然性的关节疼，发病急，关节部位出现严重的疼痛、水肿、红肿和炎症，疼痛感慢慢减轻直至消失，持续几天或几周不等。', '可通过饮用随低食物的方法，一是预防尿酸的过量产生，二是促进肾脏排泄尿酸，达到预防痛风的目的；痛风会因为尿酸在各个脏器的沉积，导致脏器微循环障碍，要积极防止心、脑血管及肾脏并发症。 限制饮酒。酒精在发酵过程中会消耗人体大量水分并产生大量嘌呤，人体内嘌令含量越多，代谢产生的尿酸就越多，同时酒精刺激肝脏也会产生尿酸，而这会增加痛风的发病率和痛风对人体的危害。', 'image/illness/tongfeng.jpg');
INSERT INTO `illness` VALUES ('3', '咳嗽', '咳嗽是一种呼吸道常见症状，由于气管、支气管黏膜或胸膜受炎症、异物、物理或化学性刺激引起，表现先是声门关闭、呼吸肌收缩、肺内压升高，然后声门张开，肺内空气喷射而出，通常伴随声音。咳嗽具有清除呼吸道异物和分泌物的保护性作用。但如果咳嗽不停，由急性转为慢性，常给患者带来很大的痛苦，如胸闷、咽痒、喘气等。咳嗽可伴随咳痰。', '咳嗽因原发疾病不同，表现亦有差异。可有发热、胸痛、咳痰、咯血、打喷嚏、流涕、咽部不适、气促等。', '选择恰当的止咳祛痰药，注意护理。当呼吸道黏膜受到异物、炎症、分泌物或过敏性因素等刺激时，即反射性地引起咳嗽，有助于排除自外界侵入呼吸道的异物或分泌物、消除呼吸道刺激因子，顽固性咳嗽可以选择中枢镇咳达到止咳目的，咳痰量多时不能单独使用止咳药应合用化痰药。', 'image/illness/kesou.jpg');
INSERT INTO `illness` VALUES ('4', '高血压', '高血压是指以体循环动脉血压（收缩压和/或舒张压）增高为主要特征（收缩压≥140毫米汞柱，舒张压≥90毫米汞柱），可伴有心、脑、肾等器官的功能或器质性损害的临床综合征。', '常见的是头晕、头痛、颈项板紧、疲劳、心悸等。仅仅会在劳累、精神紧张、情绪波动后发生血压升高，并在休息后恢复正常。随着病程延长，血压明显的持续升高，逐渐会出现各种症状。此时被称为缓进型高血压病。缓进型高血压病常见的临床症状有头痛、头晕、注意力不集中、记忆力减退、肢体麻木、夜尿增多、心悸、胸闷、乏力等。', '改善生活行为、血压控制标准个体化、多重心血管危险因素协同控制、降压药物治疗，针对高血压患者，应定期随访和测量血压，尤其注意清晨血压的管理，积极治疗高血压（药物治疗与生活方式干预并举），减缓靶器官损害，预防心脑肾并发症的发生，降低致残率及死亡率。', 'image/illness/gaoxueya.jpg');
INSERT INTO `illness` VALUES ('5', '急性肠胃炎', '急性胃肠炎是胃肠黏膜的急性炎症，临床表现主要为恶心、呕吐、腹痛、腹泻、发热等。本病常见于夏秋季，其发生多由于饮食不当，暴饮暴食；或食入生冷腐馊、秽浊不洁的食品。', '急性胃肠炎引起的轻型腹泻，一般状况良好，每天大便在10次以下，为黄色或黄绿色，少量黏液或白色皂块，粪质不多，有时大便呈“蛋花汤样”。急性胃肠炎也可以引起较重的腹泻，每天大便数次至数十次。大量水样便，少量黏液，恶心呕吐，食欲低下，有时呕吐出咖啡样物。如出现低血钾，可有腹胀，有全身中毒症状；如不规则低热或高热，烦躁不安进而精神不振，意识蒙眬，甚至昏迷。', '尽量卧床休息，病情轻者口服葡萄糖--电解质液以补充体液的丢失。如果持续呕吐或明显脱水，则需静脉补充5%～10%葡萄糖盐水及其他相关电解质。鼓励摄入清淡流质或半流质饮食，以防止脱水或治疗轻微的脱水。', 'image/illness/jixingchangweiyan.jpg');
INSERT INTO `illness` VALUES ('6', '感冒', '百姓所说的感冒是指“普通感冒”，又称“伤风”、急性鼻炎或上呼吸道感染。感冒是一种常见的急性上呼吸道病毒性感染性疾病，多由鼻病毒、副流感病毒、呼吸道合胞病毒、埃可病毒、柯萨奇病毒、冠状病毒、腺病毒等引起。', '本病起病较急，潜伏期1～3天，主要表现为鼻部症状，如喷嚏、鼻塞、流清水样鼻涕，也可表现为咳嗽、咽干、咽痒、咽痛或灼热感，甚至鼻后滴漏感。2～3天后鼻涕变稠，常伴咽痛、流泪、味觉减退、呼吸不畅、声嘶等。一般无发热及全身症状，或仅有低热、不适、轻度畏寒、头痛。', '一般治疗包括注意休息，多饮水，饮食要容易消化，注意通风等。缓解症状可使用药物治疗。', 'image/illness/ganmao.jpg');
INSERT INTO `illness` VALUES ('7', '失眠', '现在临床医学科学对失眠的认识存在局限性，但是，临床医学家们已经开始根据临床研究，给失眠进行定义，2012年中华医学会神经病学分会睡眠障碍学组根据现有的循证医学证据，制定了《中国成人失眠诊断与治疗指南》，其中失眠是指患者对睡眠时间和（或）质量不满足并影响日间社会功能的一种主观体验。', '入睡困难，入睡时间超过30分钟；睡眠质量下降，睡眠维持障碍，整夜觉	醒次数≥2次、早醒、睡眠质量下降；总睡眠时间减少，通常少于6小时容	易出现短期内体重减低，免疫功能减低和内分泌功能紊乱。', '适当运动或通过相关药物治疗。', 'image/illness/shimian.jpg');
INSERT INTO `illness` VALUES ('8', '胃溃疡', '胃溃疡是指发生在胃角、胃窦、贲门和裂孔疝等部位的溃疡，是消化性溃疡的一种。', '上腹部疼痛是本病的主要症状。多位于上腹部，也可出现在左上腹部或胸骨、剑突后。常呈隐痛、钝痛、胀痛、烧灼样痛。胃溃疡的疼痛多在餐后1小时内出现，经1～2小时后逐渐缓解，直至下餐进食后再复现上述节律。部分患者可无症状，或以出血、穿孔等并发症作为首发症状。', '应用减少损害因素的药物：如制酸剂、抗胆碱能药物、H2受体拮抗药、丙谷胺、前列腺素E2的合成剂及奥美拉唑等，同时给予胃黏膜保护的药物：如硫糖铝、铋剂、甘珀酸（生胃酮）等。彻底根除Hp，因为目前认为Hp感染与本病有关系，所以要积极治疗。', 'image/illness/weikuiyang.jpg');
INSERT INTO `illness` VALUES ('9', '流感', '流行性感冒，简称流感，是由甲、乙、丙三型流感病毒分别引起的一种急性呼吸道疾病，属于丙类传染病。', '一般表现为急性起病，前驱期有乏力症状，很快出现高热（可达39℃~40℃）、畏寒、寒战、头痛、全身肌肉关节酸痛等全身中毒症状，可伴或不伴鼻塞、流鼻涕、咽喉痛、干咳、胸骨后不适、颜面潮红、眼结膜充血等局部症状。', '流感患者大多数为轻症病例，治疗可分为一般治疗、抗病毒治疗、中医治疗等方法，如果症状较为严重，建议及时到医院就诊，听从医生的建议进行相应的检查和治疗。', 'image/illness/liugan.jpg');
INSERT INTO `illness` VALUES ('10', '贫血', '贫血是指人体外周血红细胞容量减少，低于正常范围下限的一种常见的临床症状。由于红细胞容量测定较复杂，临床上常以血红蛋白（Hb）浓度来代替。我国血液病学家认为在我国海平面地区，成年男性Hb<120g/L，成年女性（非妊娠）Hb<110g/L，孕妇Hb<100g/L就有贫血。', '贫血的病因，血液携氧能力下降的程度，血容量下降的程度，发生贫血的速度和血液、循环、呼吸等系统的代偿和耐受能力均会影响贫血的临床表现。最早出现的症状有头晕、乏力、困倦；而最常见、最突出的体征是面色苍白。症状的轻重取决于贫血的速度、贫血的程度和机体的代偿能力。', '紧急情况下，重度贫血患者、老年或合并心肺功能不全的贫血患者应输红细胞，纠正贫血，改善体内缺氧状态。但是，输血只能是临时性治疗手段，多次输血可并发血色病，需去铁治疗。因此，寻找病因进行针对性治疗是最重要的。', 'image/illness/pinxue.jpg');
INSERT INTO `illness` VALUES ('11', '肠胃炎', '胃肠炎通常因微生物感染引起，也可因化学毒物或药品导致。典型临床表现为腹泻、恶心、呕吐及腹痛。对于健康成人，胃肠炎通常只会引起不适感及生活上的不便，并不会导致严重后果，但是在病重、虚弱、年幼或年老的患者中却可以导致威胁生命的脱水和电解质紊乱。', '胃肠炎症状的类型和严重程度取决于微生物或毒物的类型和量的大小。最常见的症状是腹泻，其他症状包括：腹痛、恶心、呕吐、发热、食欲减退、体重减轻（可能是脱水的征象）、大量出汗、皮肤湿冷、肌肉痛或关节僵硬、大便失禁等。', '治疗胃肠炎应禁食、纠正水电解质紊乱。通常患者只需卧床休息并饮用足量的水分（如口服补液盐溶液）即可。即使是呕吐的患者也要尽量多饮水。呕吐剧烈时可加用止吐药。如果腹泻持续时间超过24～48小时并且没有迹象表明有更严重的细菌感染，可加用止泻药。', 'image/illness/changweiyan.jpg');

-- ----------------------------
-- Table structure for reason
-- ----------------------------
DROP TABLE IF EXISTS `reason`;
CREATE TABLE `reason` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `season` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '季节',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '原因',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of reason
-- ----------------------------
INSERT INTO `reason` VALUES ('1', '春季', '中医以为，春季养生，养肝为主，饮食也应以养肝健脾为原则。', 'image/season/chun.jpg');
INSERT INTO `reason` VALUES ('2', '夏季', '夏季进补是十分必要和有益的。夏季食补的特点首先是要清补不要滋补。', 'image/season/xia.jpg');
INSERT INTO `reason` VALUES ('3', '秋季', '秋天，有利于调养生机，去旧更新，为人体最适宜进补的季节。', 'image/season/qiu.jpg');
INSERT INTO `reason` VALUES ('4', '冬季', '冬季气候严寒，正是养精蓄锐的大好时期，人的食欲也比较旺盛，进补正是最好的时节，冬至以后尤为相宜。', 'image/season/dong.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `constellation` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '星座',
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '学校',
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '年级',
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '学院',
  `administrativeclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '行政班级',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所在地',
  `geqian` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '个性签名',
  `touxiang` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'yzx', '2001-04-27', '男', null, '湖南中医药大学', '2019级', '信息科学与工程学院', '信息管理与信息系统班', '湖南省长沙市岳麓区', '没什么好说的。', 'image/touxiang/lalala.jpg');
INSERT INTO `user` VALUES ('10', '颜自翔', '2001-01-01', null, null, '大学', '2019级', '学院', '班', '省市区', '没什么好说的', 'image/touxiang/lalala.jpg');

-- ----------------------------
-- Table structure for yangsheng
-- ----------------------------
DROP TABLE IF EXISTS `yangsheng`;
CREATE TABLE `yangsheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `season` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '季节',
  `cookbook` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '养生建议',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '食谱',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of yangsheng
-- ----------------------------
INSERT INTO `yangsheng` VALUES ('1', '春季', '木棉薏米山药瘦肉汤', '广东人常受湿邪影响，脾胃弱、大便烂，因此，可选择木棉花30克、薏米15克、山药30克，加瘦肉煲汤，既健脾又利湿热。', 'image/yangsheng/1.jpg');
INSERT INTO `yangsheng` VALUES ('2', '春季', '参芪薏米粥', '对于脾虚重者，可食用参芪薏米粥：用党参15克、北芪15克、炒薏米30克、淮山20克、大米100克煮粥。对于春湿感冒，大便糖稀，能起到健脾祛湿、补中益气的功效。', 'image/yangsheng/2.jpg');
INSERT INTO `yangsheng` VALUES ('3', '春季', '杞菊苓粥', '用枸杞10克、菊花10克、云苓20克、大米适量煮粥。有益肝肾明目、增强免疫力、抗衰老、降血糖和血压等功效。', 'image/yangsheng/3.jpg');
INSERT INTO `yangsheng` VALUES ('4', '夏季', '绿豆粥', '绿豆味甘性寒，具有清热解毒、止渴消暑、利尿润肤的功效。粳米与绿豆共煮其祛暑消烦、生津止渴及解毒效果更好。', 'image/yangsheng/4.jpg');
INSERT INTO `yangsheng` VALUES ('5', '夏季', '薄荷粥', '薄荷叶性味辛凉，气味清香。先取新鲜薄荷30克，或干薄荷15克，煎汤取汁备用。再取100克大米煮成粥，待粥将熟时加入薄荷汤及适量冰糖，煮沸一会儿即可。此粥具有清热解暑、疏风散热、清利咽喉的功效。薄荷叶性味辛凉，气味清香，很是可口。', 'image/yangsheng/5.jpg');
INSERT INTO `yangsheng` VALUES ('6', '夏季', '莲子粥', '莲子有清心除烦、健脾止泻的作用。用莲子粳米同煮成莲子粥，对夏热心烦不眠有治疗。', 'image/yangsheng/6.jpg');
INSERT INTO `yangsheng` VALUES ('7', '夏季', '荷叶粥', '取新鲜荷叶一片，洗净切碎，放入纱布袋中水煎，取浓汁150毫升，加入粳米100克，冰糖适量，加水500毫升，煮成稀粥，每天早、晚食一次。荷叶气香微涩，有清热解暑、消烦止渴、降低血压和减肥等功效，与粳米、冰糖煮粥香甜爽口，是极好的清热解暑良药。', 'image/yangsheng/7.jpg');
INSERT INTO `yangsheng` VALUES ('8', '夏季', '藿香粥', '藿香15克(鲜品加倍)，加水180毫升，煎煮2－3分钟，过滤去渣；粳米50克淘净熬粥，将熟时加入藿香汁再煮2－3分钟即可，每日温食3次。藿香味辛性温，是夏令常用药，对中暑高热、消化不良、感冒胸闷、吐泻等有理想的防治作用。', 'image/yangsheng/8.jpg');
INSERT INTO `yangsheng` VALUES ('9', '秋季', '花生红枣粥', '锅上火，加入水，放入100克花生仁煮烂，然后倒入淘洗干净的400克糯米和适量水，烧沸后加入红枣50克，再改用小火煮至米烂成粥，加入红糖调匀即成。糯米含有维生素B1、维生素B2、蛋白质、脂肪、糖类、钙、磷、铁及淀粉等，营养丰富，为温补强壮食物;花生富含丰富的蛋白质、不饱和脂肪、等营养元素，有增强记忆力的功效;红枣富含维生素A、C、E，胡萝卜素、磷等矿物质，可助于提高人体免疫力。', 'image/yangsheng/9.jpg');
INSERT INTO `yangsheng` VALUES ('10', '秋季', '木耳猪血汤', '将猪血250克切块，木耳50克撕成小块;猪血与木耳同放锅内，大火加热烧开;用微火炖到血块浮起，以盐调味即可。猪血含有多种微量元素;黑木耳则含有极为丰富的铁。', 'image/yangsheng/10.jpg');
INSERT INTO `yangsheng` VALUES ('11', '秋季', '五香茶蛋', '将400克鸡蛋和适量的清水煮10分钟，剥去外壳，加入酱油、料酒、白糖、精盐和红茶、八角、桂皮、姜和葱做成的香料包以及适量的清水，烧沸后，继续用中火稍10分钟左右即离火。鸡蛋被认为是营养丰富的食品，含有蛋白质、脂肪、卵黄素、卵磷脂、维生素和铁、钙、钾等人体所需要的矿物质。', 'image/yangsheng/11.jpg');
INSERT INTO `yangsheng` VALUES ('12', '秋季', '韭菜炒鸡蛋', '将韭菜200克切成3厘米长的段;将鸡蛋200克打入碗内搅匀待用;将炒锅烧热，倒入蛋，炒至小团块时倒出;加入韭菜，用旺火速炒、放盐，快熟时倒入鸡蛋，颠翻两下，即可出锅装盘。韭菜性味甘、温，无毒，具有温补肝肾、助阳固精的功效。鸡蛋具有养心安神、补血、滋阴润燥的作用。', 'image/yangsheng/12.jpg');
INSERT INTO `yangsheng` VALUES ('13', '秋季', '菠菜炒粉丝', '菠菜250克、粉丝100克分别用开水焯一下;锅放入麻油烧热，用葱花、姜末炝锅，烹入绍酒、素汤50毫升，将菠菜、粉丝下锅，加精盐、味精炒匀稍熬即成。菠菜中含有大量的β胡萝卜素和铁，也是维生素B6、叶酸、铁和钾的极佳来源;粉条里富含碳水化合物、膳食纤维、蛋白质、烟酸和钙、镁、铁、钾等矿物质，且有良好的附味性。', 'image/yangsheng/13.jpg');
INSERT INTO `yangsheng` VALUES ('14', '秋季', '豆芽炒肉丁', '猪肉100克切成小丁，用湿淀粉抓匀上浆;锅内加油烧至四成热，放入肉丁滑透;锅内留底油30克烧热，放入葱、姜、蒜炝锅;放入黄豆芽、料酒、酱油略炒，再放入白糖，加鲜汤、精盐，加盖用小火烧透，放入肉丁炒匀，加入味精，用湿淀粉10克勾芡，淋入明油即成。黄豆芽含有丰富的维生素，多吃克有效防治维生素B2缺乏症;猪肉含有丰富的优质蛋白质和必须的脂肪酸，能改善缺铁性贫血症。', 'image/yangsheng/14.jpg');
INSERT INTO `yangsheng` VALUES ('15', '秋季', '萝卜炖牛肉', '将萝卜450克、牛肉100克切成2里面见方的块，放入沸水中略焯;锅内加油烧热，放入大葱段、姜块、八角炸香，加入鲜汤、料酒、牛肉块，炖至熟烂再加入萝卜块，待萝卜块熟烂，加入精盐、酱油、味精，拣出葱、姜、八角稍煮即成。白萝卜含有丰富的维生素;牛肉含有丰富的蛋白质，氨基酸组成比猪肉更接近人体需要，能调高机体抗病能力。', 'image/yangsheng/15.jpg');
INSERT INTO `yangsheng` VALUES ('16', '秋季', '椒油炝藕片', '鲜藕500克切成薄片，锅中放清水烧开后倒进莲藕焯熟，捞进凉开水里;藕片加精盐、酱油、醋、味精拌匀盛入盘内，放上姜末;最后用花椒油炝在藕片上即可。莲藕含铁量高，所以对缺铁性贫血的病人特别适合;其次莲藕所含植物蛋白质、维生素以及淀粉含量都很丰富，有明显的补益气血，增强人体免疫力作用。', 'image/yangsheng/16.jpg');
INSERT INTO `yangsheng` VALUES ('17', '秋季', '萝卜丝带鱼', '带鱼250克切段，放入盆中加盐，黄酒8克，湿淀粉拌匀;萝卜100克切成丝焯水;油锅上火烧至八成热将带鱼放入，炸至呈金黄色;锅里留少许油，放入葱姜煸香，放入带鱼，萝卜丝，加水、黄酒、糖、盐烧开，加味精即可。带鱼富含丰富不饱和脂肪酸，具有降低胆固醇的作用;白萝卜可助于消化，提高抗病能力。', 'image/yangsheng/17.jpg');
INSERT INTO `yangsheng` VALUES ('18', '冬季', '山药炒鱼片', '将草鱼宰杀干净之后切片，然后用生粉搅拌备用;将山药去皮之后切片备用;在油锅中就加入葱姜蒜爆香，随后放入准备好的山药、鱼片爆炒，随后放入葱姜蒜以及食盐、料酒;炒熟之后就可以起锅了。健脾益胃、助消化。', 'image/yangsheng/18.jpg');
INSERT INTO `yangsheng` VALUES ('19', '冬季', '栗子红薯糖水', '栗子用热水浸泡5~10分钟，趁热剥去外衣;红薯洗净，削去外皮，切块;将5碗水倒入煲内，下栗子加盖大火烧开，转中火煮10分钟;再下红薯和姜片，煮至红薯绵软，下红糖调味即可饮用。益气健脾，厚补胃肠，抗衰防老。', 'image/yangsheng/19.jpg');
INSERT INTO `yangsheng` VALUES ('20', '冬季', '冰糖白萝卜饮', '把白萝卜洗净，擦干水，在萝卜的上部1/3处横切一刀，上部1/3处放在一边，用小刀把下部中心掏空，在挖空处放入冰糖。再把切去的1/3白萝卜盖好，周边用牙签固定好，把萝卜放入密封罐，放入冰箱保存，五六天后拿出来，打开萝卜，里面的冰糖已化为浓汁。将汁水滗出，再加少许蜂蜜即可。润肺止咳，预防咽喉肿痛等秋季常见疾病。', 'image/yangsheng/20.jpg');
INSERT INTO `yangsheng` VALUES ('21', '冬季', '茶树菇玉米排骨汤', '洗净精肋排，放在开水里焯一下捞出，再用温热水冲去表面的浮末;茶树菇用温水泡片刻，剪去老根，冲洗干净，姜切片，待用。将锅烧热，放少量油(喜欢特别清淡的汤可省略这个过程)，至六成热，将焯好的肋排和姜片用小火慢慢翻炒片刻，加开水，和泡好的茶树菇一起放入汤锅里煲熟。甜玉米洗净，切成小段，放入煮好的汤里，加适量盐煲20分钟，调入适量鸡粉，关火，稍微焖一下即可。这款汤既可滋润皮肤，又可防癌。', 'image/yangsheng/21.jpg');
