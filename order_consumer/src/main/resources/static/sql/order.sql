/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : order

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2020-05-20 19:21:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dishesinfo
-- ----------------------------
DROP TABLE IF EXISTS `dishesinfo`;
CREATE TABLE `dishesinfo` (
  `dishesid` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品编号，主键，自动增长',
  `dishesname` varchar(50) NOT NULL COMMENT '菜品名称',
  `dishesdiscript` varchar(100) NOT NULL COMMENT '菜品的简单介绍',
  `dishesimg` varchar(100) NOT NULL DEFAULT '0.jpg' COMMENT '菜品图片文件名称',
  `dishestxt` varchar(400) NOT NULL COMMENT '菜品详细介绍',
  `recommend` int(11) NOT NULL DEFAULT '0' COMMENT '是否推荐菜品：0-非推荐，1-推荐菜品',
  `dishesprice` varchar(50) NOT NULL COMMENT '菜品单价',
  PRIMARY KEY (`dishesid`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dishesinfo
-- ----------------------------
INSERT INTO `dishesinfo` VALUES ('1', '白灼基围虾', '营养丰富，肉质松软', '/img/upload/1.jpg', '白灼基围虾是一道色香味俱全的地方名菜，属于粤菜系。由基围虾和柠檬为主要原材料做成的菜肴，营养丰富，且其肉质松软，易消化。在粤菜里，灼，是传统的一种烹饪技法，它可以在不改变食材本味的前提在，使食材达到爽、嫩、滑的境界。“白灼”也是突出粤菜清淡的手法之一。灼的标准定义为：以煮滚的水或汤，将生的食物烫熟。', '1', '40');
INSERT INTO `dishesinfo` VALUES ('2', '冰糖湘莲', '口腹累人良可笑，此身便欲老湖湘', '/img/upload/2.jpg', '冰糖湘莲是湖南是一道汉族名菜。自西汉年间用白莲向汉高祖刘邦进贡，故湘莲又称贡莲，湘莲主要产于洞庭湖区一带，湘潭为著名产区，市内以花石、中路铺两地所产最多，质量也最好，有红莲、白莲之分，其中白莲圆滚洁白，粉糯清香，位于全国之首。在挖掘湖南长沙马王堆墓时，发现候就食用过莲子。金代诗人张楫品尝“心清犹带小荷香”的新白莲后，曾发出“口腹累人良可笑，此身便欲老湖湘”的感叹。莲子含有丰富的蛋白质、脂肪和碳水化合物，莲子中的钙、磷和钾含量非常丰富，除可以构成骨骼和牙齿的成分外，还有促进凝血，使某些酶活化，维持神经传导性，镇静神经，维持肌肉的伸缩性和心跳的节律等作用。', '1', '25');
INSERT INTO `dishesinfo` VALUES ('3', '豉香黄花鱼', '健脾升胃、安神止痢、益气填精', '/img/upload/3.jpg', ' 黄花鱼含有丰富的蛋白质、微量元素和维生素，对人体有很好的补益作用，对体质虚弱和中老年人来说，食用黄花鱼会收到很好的食疗效果。黄花鱼含有丰富的微量元素硒，能清除人体代谢产生的自由基，能延缓衰老，并对各种癌症有防治功效。中医认为，黄花鱼有健脾升胃、安神止痢、益气填精之功效，对贫血、失眠、头晕、食欲不振及妇女产后体虚有良好疗效。 《本草纲目》记载黄花鱼“甘平无毒，合莼菜作羹，开胃益气。晾干称为白鲞，炙食能治暴下痢，及卒腹胀不消，鲜者不及”。', '1', '40');
INSERT INTO `dishesinfo` VALUES ('4', '葱爆鱿鱼', '色感口感俱佳', '/img/upload/4.jpg', '葱爆鱿鱼，菜肴名称，取名独特，色感口感俱佳，深受当地民众喜爱。', '1', '45');
INSERT INTO `dishesinfo` VALUES ('5', '大酱汤', '营养丰富，味道鲜美', '/img/upload/5.jpg', '大酱汤日式是日本传统美食之一，是用日式海带 、葱花、 金针菇、 圆葱、日式大酱等食材制作而成的汤料，不但营养丰富，而且味道鲜美。制作时先把水烧开，放入自己喜欢的配料。', '1', '36');
INSERT INTO `dishesinfo` VALUES ('6', '蛋黄南瓜', '皮酥质糯、风味独特', '/img/upload/6.jpg', '蛋黄南瓜，口味咸甜，色泽金黄、咸甜香浓、皮酥质糯、风味独特。', '1', '22');
INSERT INTO `dishesinfo` VALUES ('7', '灯影牛肉', '味麻辣鲜脆，细嚼之，回味无穷', '/img/upload/7.jpg', '灯影牛肉是四川达州和重庆地区汉族传统名吃。已有100多年历史。把牛后腿腱子肉切片后，经腌、晾、烘、蒸、炸、炒等工序制作而成。麻辣香甜，深受人们喜爱。因肉片薄而宽，可以透过灯影，有民间皮影戏之效果而得名。牛肉片薄如纸，色红亮，味麻辣鲜脆，细嚼之，回味无穷。市场上生产“灯影牛肉”产品的品牌众多，重庆等地亦出现不少品牌，不过最为正宗的还是为达州本地品牌“灯影”牌。', '1', '39');
INSERT INTO `dishesinfo` VALUES ('8', '地三鲜', '鲜爽无比，百吃不厌', '/img/upload/8.jpg', '地三鲜，是一道东北传统名菜，制作材料是三种地里时令新鲜的食材：茄子、土豆和青椒。它不仅在于鲜浓的味道、天然绿色的食材，更胜于它涵盖多种食材的营养，让三味非常普通的食材做成鲜爽无比的佳肴。', '1', '29');
INSERT INTO `dishesinfo` VALUES ('9', '东安子鸡', '味道酸辣鲜香', '/img/upload/9.jpg', '东安子鸡又叫东安鸡、官保鸡，是一道地方传统名菜，属于湘菜系。因用东安新母鸡烹制而成，故名。东安子鸡成菜呈红白绿黄四色，鸡肉肥嫩，味道酸辣鲜香。', '1', '50');
INSERT INTO `dishesinfo` VALUES ('10', '东坡肉', '入口香糯、肥而不腻，酥烂而形不碎', '/img/upload/10.jpg', '东坡肉，杭州名菜，流行于江浙。相传为北宋诗人苏东坡所创制。制作方法：将五花肉切成大块，用葱姜垫锅底，加上酒、糖、酱油，用水在文火上慢焖即可。东坡肉是杭州名菜，用猪肉炖制而成。其色、香、味俱佳，深受人们喜爱。慢火，少水，多酒，是制作这道菜的诀窍。一般是一块约二寸许的方正形猪肉，一半为肥肉，一半为瘦肉，入口香糯、肥而不腻，带有酒香，色泽红亮，味醇汁浓，酥烂而形不碎，十分美味。', '1', '59');
INSERT INTO `dishesinfo` VALUES ('11', '剁椒鱼头', '肉质细嫩、鲜辣适口，风味独具一格', '/img/upload/11.jpg', '剁椒鱼头属湘菜系，是湘潭的一道名菜。以鱼头的“味鲜”和剁辣椒的“辣”为一体，肥而不腻、肉质细嫩、鲜辣适口，风味独具一格。特别指出的是此菜所使用的油是茶油。剁椒鱼头味辣、偏咸鲜，尤以湖南湘潭所作最为出名，风味独具一格。湖南湘潭的剁椒鱼头是在大街小巷的大小餐馆酒店都可以吃到的。它的来历和清代著名文人黄宗宪有关。火辣辣的红剁椒，覆盖着白嫩嫩的鱼头肉，冒着热腾腾清香四溢的香气。据说清朝雍正年间，黄宗宪为了躲避文字狱，逃到湖南一个小村子，借住农户家。这家人很穷，买不起菜，幸好晚上吃饭前，农户的儿子捞了一条河鱼回家。于是，女主人就在鱼肉里面放盐煮汤，再将辣椒剁碎后与鱼头同蒸。黄宗宪觉得非常鲜美，从此对鱼头情有独钟。避难结束后，他让家里厨师加以改良，就成了今天的湖南名菜剁椒鱼头。', '1', '49');
INSERT INTO `dishesinfo` VALUES ('12', '飞龙汤', '肉质鲜美，营养丰富', '/img/upload/12.jpg', '飞龙又名榛鸡是黑龙江省的名菜之一，属于龙江菜系，产于兴安岭。飞龙汤是将榛鸡脱毛去掉内脏后，用高汤煮熟即可，汤中不需放任何调料以保持汤原汁原味。飞龙汤肉质鲜美，营养丰富，适合用作滋补汤品。', '1', '45');
INSERT INTO `dishesinfo` VALUES ('13', '佛跳墙', '可促进发育，美容，延缓衰老，增强免疫力', '/img/upload/13.jpg', '佛跳墙，又名满坛香、福寿全，是福建福州的当地名菜，属闽菜系。相传，它是在清道光年间由福州聚春园菜馆老板郑春发研制出来的。佛跳墙富含营养，可促进发育，美容，延缓衰老，增强免疫力，乃进补佳品。', '1', '66');
INSERT INTO `dishesinfo` VALUES ('14', '夫妻肺片', '质嫩味鲜，麻辣浓香，非常适口', '/img/upload/14.jpg', '夫妻肺片是一道四川成都名菜，由郭朝华、张田政夫妻创制而成，制作精细，色泽美观，质嫩味鲜，麻辣浓香，非常适口，被评为四川十大经典名菜。', '1', '30');
INSERT INTO `dishesinfo` VALUES ('15', '宫保鸡丁', '红而不辣、辣而不猛、香辣味浓、肉质滑脆', '/img/upload/15.jpg', '宫保鸡丁，是一道闻名中外的特色传统名菜。鲁菜、川菜、贵州菜中都有收录，原料、做法有差别。该菜式的起源与鲁菜中的酱爆鸡丁，和贵州菜的胡辣子鸡丁有关，后被清朝山东巡抚、四川总督丁宝桢改良发扬，形成了一道新菜式——宫保鸡丁，并流传至今，此道菜也被归纳为北京宫廷菜。之后宫保鸡丁也流传到国外。\r\n\r\n宫保鸡丁选用鸡肉为主料，佐以花生米、黄瓜、辣椒等辅料烹制而成。 红而不辣、辣而不猛、香辣味浓、肉质滑脆。由于其入口鲜辣，鸡肉的鲜嫩配合花生的香脆。', '0', '29');
INSERT INTO `dishesinfo` VALUES ('16', '咕噜肉', '其味酸甜可口，吃时有弹性', '/img/upload/16.jpg', '咕噜肉(Sweet and Sour Pork )[1]，又名古老肉，是一道广东的传统特色名菜。此菜始于清代。当时在广州市的许多外国人都非常喜欢食用中国菜，尤其喜欢吃糖醋排骨，但吃时不习惯吐骨。\r\n\r\n广东厨师即以出骨的精肉加调味与淀粉拌和制成一只只大肉圆，入油锅炸，至酥脆，粘上糖醋卤汁，其味酸甜可口，受到中外宾客的欢迎。糖醋排骨的历史较老，现经改制后，便改称为“古老肉”。外国人发音不准，常把“古老肉”叫做“咕噜肉”，因为吃时有弹性，嚼肉时有格格声，故长期以来这两种称法并存。此菜在国内外享有较高声誉。市面上常见的是罐头菠萝搭配的咕噜肉。', '0', '36');
INSERT INTO `dishesinfo` VALUES ('17', '广式糯米卷', '松软柔韧，香甜软糯', '/img/upload/17.jpg', '广式糯米卷是广东茶楼常见的点心，面粉皮包裹着糯米蒸制而成，入口既能品尝到北方面粉的松软柔韧，又可以感受南方糯米的香甜软糯。', '0', '18');
INSERT INTO `dishesinfo` VALUES ('18', '蚝油杏鲍菇', '低蛋白质，富含维生素C', '/img/upload/18.jpg', '蚝油杏鲍菇是一道家常美味的菜肴。适用于日常家庭聚餐，是集保健、营养、药用、食疗于一体的珍稀食用菌类种，含有我们人体所需要的蛋白质、维生素、氨基酸、蛋白质及各种矿物质，我们食用是有很好的美容养颜、降血脂、降血压、降胆固醇、润通肠道的作用。', '0', '24');
INSERT INTO `dishesinfo` VALUES ('19', '荷塘小炒', '适合减肥中的女孩子吃', '/img/upload/19.jpg', '荷塘小炒是指粤菜在菜品的颜色和营养的配搭上是很讲究的，素菜也不例外。例如这道“荷塘小炒”，无论是在色泽、营养还是口味上，都可堪称是素菜中的经典，尤其适合减肥中的女孩子吃。', '0', '20');
INSERT INTO `dishesinfo` VALUES ('20', '红烧带鱼', '鱼肉细腻鲜嫩，口味咸中带甜', '/img/upload/20.jpg', '红烧带鱼是用带鱼制作的一道家常菜。鱼肉嫩体肥、味道鲜美，除了中间的大骨外，鱼身便无细刺，很适合小孩子和怕鱼刺者食用。红烧带鱼肉质细嫩，枣红色，咸甜口。此菜色酱红光亮，鱼肉细腻鲜嫩，口味咸中带甜。', '0', '38');
INSERT INTO `dishesinfo` VALUES ('21', '红烧肉', '肥瘦相间，香甜松软，入口即化', '/img/upload/21.jpg', '红烧肉是一道著名的大众菜肴，属于热菜。其以五花肉为制作主料，最好选用肥瘦相间的三层肉（五花肉）来做，做法多达二三十种。做出来的肉肥瘦相间，香甜松软，入口即化。', '0', '36');
INSERT INTO `dishesinfo` VALUES ('22', '红糖糍粑', '营养丰富，释放热量快，营养吸率高', '/img/upload/22.jpg', '红糖糍粑是用红糖、糯米制作的一道川渝地区传统小吃。红糖营养丰富，释放热量快，营养吸率高，除含蔗糖以外，还含有少量的铁、钙、胡萝卜素等物质。', '0', '18');
INSERT INTO `dishesinfo` VALUES ('23', '虎皮青椒', '气味清香，口感鲜辣，绵而不烂', '/img/upload/23.jpg', '虎皮青椒，又叫虎皮海椒、糖醋辣椒瘪子，是以青椒为主要材料制作的一道菜品，因青椒表面炒得略微焦糊，斑驳的焦糊点如同老虎的花纹而得名。\r\n\r\n只要将洗净的青椒入锅，干炒至表皮起皱。加入油后，翻炒至表皮膨胀皱纹剧增即可。原料便宜，做工简单。成菜后，气味清香，口感鲜辣，绵而不烂。有疾患者应少食或忌食。', '0', '20');
INSERT INTO `dishesinfo` VALUES ('24', '回锅肉', '口味独特，色泽红亮，肥而不腻，入口浓香', '/img/upload/24.jpg', '回锅肉起源四川农村地区。古代时期称作油爆锅；四川地区大部分家庭都会制作。所谓回锅，就是再次烹调的意思。回锅肉在川菜中的地位是非常重要的，回锅肉一直被认为是川菜之首，川菜之化身，提到川菜必然想到回锅肉。它色香味俱全，颜色养眼，是下饭菜的首选。配料各有不同，除了蒜苗（青蒜）还可以用彩椒，洋葱，韭菜，锅盔等来制作回锅肉，每家都有自己的秘方。', '0', '29');
INSERT INTO `dishesinfo` VALUES ('25', '鲫鱼汤', '对肌肤的弹力纤维构成能起到很好的强化作用', '/img/upload/25.jpg', '鲫鱼汤是一道以鲫鱼、豆腐、蘑菇等作为食材制作而成的汤，含有全面而优质的蛋白质，对肌肤的弹力纤维构成能起到很好的强化作用。尤其对压力、睡眠不足 等精神因素导致的早期皱纹，有奇特的缓解功效。\r\n\r\n适宜慢性肾炎水肿，肝硬化腹水，营养不良性浮肿之人食用;适宜孕妇产后乳汁缺少之人食用;适宜脾胃虚弱，饮食不香之人食用;适宜小儿麻 疹初期，或麻疹透发不快者食用;适宜痔疮出血，慢性久痢者食用;感冒发热期间不宜多吃。', '0', '39');
INSERT INTO `dishesinfo` VALUES ('26', '咖喱鱼蛋', '口感弹牙，鲜嫩，海鲜味十足', '/img/upload/26.jpg', '咖喱鱼蛋（食肆通常简写作鱼旦）是一道美味可口的汉族小吃，属于闽菜，粤菜。此菜口感弹牙，鲜嫩，海鲜味十足。因酱料不同有甜辣、酸甜等各种口味。咖喱鱼蛋是用特种咖喱粉及各种秘制酱料将正宗的潮汕鱼丸或者台湾鱼丸或者福建鱼丸在锅中煮，待鱼丸煮熟后盛出淋上甜辣酱或蕃茄酱等，即可食用的鱼丸。', '0', '24');
INSERT INTO `dishesinfo` VALUES ('27', '开水白菜', '清鲜淡雅，香味浓醇，汤味浓厚，不油不腻', '/img/upload/27.jpg', '开水白菜是一道四川名菜，原系川菜名厨黄敬临在清宫御膳房时创制，后来由川菜大师罗国荣发扬光大，成为国宴上的一道精品。\r\n\r\n开水白菜以北方的大白菜心来制作，配以用鸡，鸭，排骨熬煮，并用鸡肉蓉，猪肉蓉澄澈的高汤调味，最后浇汤时在汤里淋一些鸡油。成菜后，清鲜淡雅，香味浓醇，汤味浓厚，不油不腻，却清香爽口。', '0', '15');
INSERT INTO `dishesinfo` VALUES ('28', '口水鸡', '集麻辣鲜香嫩爽于一身', '/img/upload/28.jpg', '口水鸡是中国四川传统特色菜肴，属于川菜系中的凉菜，佐料丰富，集麻辣鲜香嫩爽于一身。 在烹制时，煮鸡用的汤料很有讲究，需要恰到好处，这样可以最大限度地保存鸡的可溶性蛋白，增加鸡肉的鲜美程度，又能具备其特有的香型和滋味。\r\n\r\n口水鸡是一道凉菜，佐料丰富，集麻辣鲜香嫩爽于一身。有“名驰巴蜀三千里，味压江南十二州”的美称。“口水鸡”这名字初听感觉有点不雅，脑子里可能会出现一副口水滴哒的样子，之所以叫口水鸡还因为有很多花椒，吃了会麻到嘴巴瘫痪不由自主流口水。', '0', '35');
INSERT INTO `dishesinfo` VALUES ('29', '口味蛇', '质地细腻、滋味鲜美', '/img/upload/29.jpg', '口味蛇，是一道湖南省传统的名菜，属于湘菜系。此菜选用高蛋白，低脂肪，肉质细嫩的本地蛇作原料，配制以鲜、香、辣为主要特征的口味。蛇肉的胆固醇含量很低，对防治血管硬化有一定的作用。\r\n\r\n蛇肉质地细腻、滋味鲜美，而且还富有很高的营养价值，是深受人们喜爱的美味佳肴。', '0', '39');
INSERT INTO `dishesinfo` VALUES ('30', '腊味合蒸', '腊香浓重，咸甜适口，色泽红亮，柔韧不腻，稍带厚汁', '/img/upload/30.jpg', '腊味合蒸是湖南 传统名菜之一，是取腊肉、腊鸡、腊鱼于一钵，加入鸡汤和调料，下锅清蒸而成。徐睿称，腊味是湖南特产，主要有猪、牛、鸡、鱼、鸭等品种，将三种腊味一同蒸熟即为“腊味合蒸”，此菜腊香浓重，咸甜适口，色泽红亮，柔韧不腻，稍带厚汁，且味道互补，各尽其妙，是湘菜中传统风味名菜。', '0', '36');
INSERT INTO `dishesinfo` VALUES ('31', '辣椒炒肉', '口味香辣', '/img/upload/31.jpg', '辣椒炒肉是以辣椒、五花肉作为主要食材，以豆豉，大蒜子，酱油，油盐，味精等作为辅料制作而成的一道菜肴。口味香辣。\r\n\r\n辣椒炒肉是湖南人每家每户必吃的招牌“土菜”，是最具代表性的湘菜之一。', '0', '29');
INSERT INTO `dishesinfo` VALUES ('32', '辣子鸡', '麻辣味浓。咸鲜醇香，略带回甜', '/img/upload/32.jpg', '辣子鸡，是一道经典的川渝地区的特色传统名肴。一般以鸡为主料，加上葱、干辣椒、花椒、盐、胡椒、味精等多种材料精制而成，营养丰富，味道鲜美，虽然是同一道菜，各地制作也各有特色。\r\n\r\n辣子鸡因各地的不同制作方法也有不同的特色，深受各地人们的喜爱。此菜成菜色泽棕红油亮，麻辣味浓。咸鲜醇香，略带回甜。', '0', '29');
INSERT INTO `dishesinfo` VALUES ('33', '凉拌黄豆芽', '鲜香嫩脆，色泽美观', '/img/upload/33.jpg', '凉拌黄豆芽是一种营养丰富，味道鲜美的菜品，制作原料主要有黄豆芽、醋，味精等。此菜，鲜香嫩脆，色泽美观。与炒黄豆芽比，不及其香，胜过其嫩，夏季食用最宜。', '0', '12');
INSERT INTO `dishesinfo` VALUES ('34', '龙井虾仁', '色泽淡雅，味美清口', '/img/upload/34.jpg', '龙井虾仁因选用清明节前后的龙井茶配以虾仁制作而得名，是一道具有浓厚地方风味的杭州名菜。\r\n\r\n成菜后，虾仁白嫩、茶叶翠绿，色泽淡雅，味美清口。', '0', '32');
INSERT INTO `dishesinfo` VALUES ('35', '麻婆豆腐', '扬名海内外，深得国内外美食者好评', '/img/upload/35.jpg', '麻婆豆腐始创于清朝同治元年（1862年），开创于成都外北万福桥边。由于陈麻婆豆腐历代传人的不断努力，陈麻婆川菜馆虽距今一百四十余年盛名长盛不衰。并扬名海内外，深得国内外美食者好评。麻婆豆腐也成为了具有四川代表性的名菜，麻婆豆腐是四川省汉族传统名菜之一，属于川菜系。主要原料为配料和豆腐，材料主要有豆腐、牛肉末（也可以用猪肉）、辣椒和花椒等。麻来自花椒，辣来自辣椒，这道菜突出了川菜“麻辣”的特点。此菜大约在清代同治初年（1874年以后），由成都市北郊万福桥一家名为“陈兴盛饭铺”的小饭店老板娘陈刘氏所创。因为陈刘氏脸上有麻点，人称陈麻婆，她发明的烧豆腐就被称为“陈麻婆豆腐”。', '0', '22');
INSERT INTO `dishesinfo` VALUES ('36', '毛血旺', '汤汁红亮、麻辣鲜香、味浓味厚', '/img/upload/36.jpg', '毛血旺以鸭血为制作主料，烹饪技巧以煮菜为主，口味属于麻辣味。起源于重庆，流行于重庆和西南地区，是一道著名的传统菜式。这道菜是将生血旺现烫现吃，且毛肚杂碎为主料，遂得名。\r\n\r\n毛血旺是重庆市的特色菜，也是渝菜江湖菜的鼻祖之一，已经列入国家标准委员会《渝菜烹饪标准体系》。\r\n\r\n麻辣诱惑对传统的毛血旺进行了改良和创新，将其汤汁红亮、麻辣鲜香、味浓味厚的特点不断发扬光大。', '0', '30');
INSERT INTO `dishesinfo` VALUES ('37', '排骨山药汤', '健脾胃，强健身体', '/img/upload/37.jpg', '山药中含有多种营养元素，能够健脾胃，强健身体，同时还有一定的润肺止咳作用。此外它也是糖尿病人的理想食物，有一定的降低血糖的作用，还能够预防心血管疾病，延年益寿。', '0', '26');
INSERT INTO `dishesinfo` VALUES ('38', '皮蛋豆腐', '促进营养的消化吸收，降压', '/img/upload/38.jpg', '皮蛋豆腐属于凉菜、拌菜，主要原料是皮蛋、豆腐等，口味是微辣，工艺是拌，烹饪难度属于初级。皮蛋是用石灰等原料腌制后的蛋类食品，较鸭蛋含更多矿物质，脂肪和总热量却稍有下降，它能刺激消化器官，增进食欲，促进营养的消化吸收，降压等功效。豆腐营养丰富，含有铁、钙、磷、镁等人体必需的多种微量元素，素有“植物肉”之美称。', '0', '18');
INSERT INTO `dishesinfo` VALUES ('39', '清炒茭白', '一莹白一碧绿，视觉效果极佳', '/img/upload/39.jpg', '用极具中国特色、营养丰富的水生植物茭白，搭配人们喜食的调味佳品蔬菜青椒。一莹白一碧绿，视觉效果极佳。', '0', '19');
INSERT INTO `dishesinfo` VALUES ('40', '清炒苦瓜', '清热消暑、养血益气、补肾健脾、滋肝明目', '/img/upload/40.jpg', '清炒苦瓜，菜肴名称，油要多一些，火要旺，炒出来的菜才好吃。具有清热消暑、养血益气、补肾健脾、滋肝明目的功效，对治疗痢疾、疮肿、中暑发热、痱子过多、结膜炎等病有一定的功效。苦瓜性凉，脾胃虚寒者不宜食用。', '0', '19');
INSERT INTO `dishesinfo` VALUES ('41', '清炒生菜', '镇痛催眠、降低胆固醇', '/img/upload/41.jpg', '清炒生菜是由生菜，葱，小辣椒，盐，鸡精等材料做成的美食。清炒生菜具有生菜本身具备的功效，如镇痛催眠、降低胆固醇、辅助治疗神经衰弱、利尿、促进血液循环、抗病毒等。', '0', '19');
INSERT INTO `dishesinfo` VALUES ('42', '清蒸江团', '肉质肥美细嫩，汤清味鲜', '/img/upload/42.jpg', '清蒸江团是四川乐山地区汉族传统名菜，属于川菜系。用江团鱼和火腿等为原料，经清蒸而成。成菜形状美观，肉质肥美细嫩，汤清味鲜。', '0', '39');
INSERT INTO `dishesinfo` VALUES ('43', '肉沫茄子', '色香味俱全，营养丰富', '/img/upload/43.jpg', '肉沫茄子，是一道美味的家常菜。以茄子和肉为主料，辅料有大蒜、盐、味精、白糖、酱油、葱片、姜丝等制作而成。其做法简单，色香味俱全，营养丰富。且具有防治高血压、冠心病和防治坏血病及促进伤口愈合的功效。', '0', '26');
INSERT INTO `dishesinfo` VALUES ('44', '十三香小龙虾', '美味可口，营养丰富', '/img/upload/44.jpg', '十三香小龙虾，美味可口，营养丰富，营养价值高，其肉味鲜美，营养丰富。具有壮阳补肾、通乳生乳、化瘀解毒等功效。', '0', '68');
INSERT INTO `dishesinfo` VALUES ('45', '水晶肘子', '肥而不腻，清爽适口', '/img/upload/45.jpg', '水晶肘子选用猪时肉为主料，配以芝麻酱、绿豆淀粉等，经过多道工序烹制此菜，晶莹透明，肘肉透烂，肥而不腻，清爽适口，最宜夏令食用。', '0', '58');
INSERT INTO `dishesinfo` VALUES ('46', '四喜丸子', '寓人生福、禄、寿、喜四大喜事', '/img/upload/46.jpg', '四喜丸子，是经典的中国传统名菜之一，属于鲁菜菜系。由四个色、香、味俱佳的肉丸组成，寓人生福、禄、寿、喜四大喜事。常用于喜宴、寿宴等宴席中的压轴菜，以取其吉祥之意。', '0', '36');
INSERT INTO `dishesinfo` VALUES ('47', '素炒空心菜', '具有清热解毒的功效', '/img/upload/47.jpg', '素炒空心菜是一道美食，主要原料是空心菜、葱等，本品具有清热解毒的功效，适于痢疾患者', '0', '19');
INSERT INTO `dishesinfo` VALUES ('48', '酸菜鱼', '口味酸辣可口', '/img/upload/48.jpg', '酸菜鱼也称为酸汤鱼，是一道源自重庆的经典菜品，以其特有的调味和独特的烹调技法而著称。流行于上世纪90年代，是重庆江湖菜的开路先锋之一。\r\n\r\n酸菜鱼以草鱼为主料，配以泡菜等食材煮制而成，口味酸辣可口；鱼含丰富优质蛋白，能提供人丰富的蛋白质、矿物质等营养；酸菜中的乳酸可以促进人体对铁元素的吸收，还可以增加人的食欲。\r\n\r\n关于酸菜鱼的历史来源众说纷纭，至今也无法考证，后经传承，制作方法现在也各有不同，但口味基本一致。', '0', '39');
INSERT INTO `dishesinfo` VALUES ('49', '酸辣土豆丝', '色泽光亮，酸辣可口，让人口齿生津，酸辣易下饭', '/img/upload/49.jpg', '主料土豆性平和，有美容、改善胃肠功能，预防高血压的功效。辅料辣椒富含维生素C，可增强体质、防止冠状动脉硬化。该菜用料简单，好学易做，营养丰富，清爽可口，很受人欢迎。', '0', '19');
INSERT INTO `dishesinfo` VALUES ('50', '酸溜白菜', '色泽银红，酸甜辣香', '/img/upload/50.jpg', '酸溜白菜口感色泽银红，酸甜辣香。而白菜含有丰富的钙、铁、无机盐的维生素C等', '0', '19');
INSERT INTO `dishesinfo` VALUES ('51', '蒜香荷兰豆', '增强免疫力、护眼明目', '/img/upload/51.jpg', '提高机体的抗病能力和康复能力。防止人体致癌物质的合成，从而减少癌细胞的合成，预防癌症的发生。具有抗菌消炎，增强新陈代谢的功效。可以促进胃肠蠕动，防止便秘，益脾和胃，生津止渴，起到清肠利尿的作用。', '0', '22');
INSERT INTO `dishesinfo` VALUES ('52', '糖醋鱼块', '做法简单，用料简单，营养丰富', '/img/upload/52.jpg', '糖醋鱼块是山东地区特色传统名菜，属于鲁菜菜系。糖醋鱼块以花生为主要材料，做法非常简单，只要按照菜谱步骤就能做出一道美味菜肴。', '0', '39');
INSERT INTO `dishesinfo` VALUES ('53', '外婆菜', '开胃下饭、降血脂、软化血管、滋养容颜', '/img/upload/53.jpg', '外婆菜的主要食材为芽菜、阳光豆豉、老豆腐、五花肉沫，是湖南湘西地区的一道家常菜，原料选用多种野菜、湘西土菜，以湘西传统的民间制作方法晒干放入坛内腌制而成，不添加任何色素和防腐剂。外婆菜是难得一见的时尚湘菜，口感极好，嚼之有劲，品之逾香，具有开胃下饭、降血脂、软化血管、滋养容颜的功效。', '0', '20');
INSERT INTO `dishesinfo` VALUES ('54', '豌豆炒牛肉', '含有较为丰富的膳食纤维', '/img/upload/54.jpg', '含有丰富的蛋白质，氨基酸组成比猪肉更接近人体需要，能提高机体抗病能力，对生长发育及手术后、病后调养的人在补充失血、修复组织等方面特别适宜', '0', '29');
INSERT INTO `dishesinfo` VALUES ('55', '莴笋炒山药', '降低血压、去除口臭', '/img/upload/55.jpg', '莴笋性凉、味微苦；归胃、大肠经。具有降低血压、促进排尿、消除脂肪沉积、去除口臭等功效。中医认为，莴笋中含有一种芳香烃羟化脂，对于肝癌、胃癌有预防作用，也可缓解癌症患者放疗或化疗的不良反应，是一种抗癌蔬菜。患有尿血及水肿、产后缺奶或乳汁不通等症患者食用莴笋，能起到治疗作用。莴笋含氟丰富，对牙齿有保护作用，参与骨骼的生化过程，对儿童有益。', '0', '26');
INSERT INTO `dishesinfo` VALUES ('56', '西红柿炒蛋', '口味宜人，爽口、开胃', '/img/upload/56.jpg', '西红柿炒鸡蛋，又名番茄炒蛋，是许多百姓家庭中一道普通的大众菜肴。烹饪方法简单易学，营养搭配合理。鲜艳，口味宜人，爽口、开胃，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及健美抗衰老的作用。', '0', '20');
INSERT INTO `dishesinfo` VALUES ('57', '西红柿土豆炖牛肉', '口味鲜美，营养丰富', '/img/upload/57.jpg', '西红柿土豆炖牛肉是一道菜品，制作原料主要有牛腩、西红柿、土豆等，口味鲜美，营养丰富。将土豆、西红柿与牛肉一起炖煮，不仅使牛肉更加酥烂香甜，且增加了牛肉的营养价值。', '0', '30');
INSERT INTO `dishesinfo` VALUES ('58', '香菜豆腐羹', '入口即化，味道鲜美', '/img/upload/58.jpg', '香菜豆腐羹是一道色香味俱全的传统名肴。此菜在江浙地区较流行。猪肉末少许，放料酒，盐及少许生粉捏拌均匀。香菜洗净切成末，嫩豆腐一盒切成小快；烧热锅，放少许油，入肉末煸炒至变色，加入高汤(没有高汤清水亦可)；锅里煮沸后，转小火煮5分钟让肉末出味，撇去浮末，接着下嫩豆腐一起煮几分钟入味；放盐及胡椒粉，用薄薄的水淀粉勾芡，起锅前撒入香菜末即可。', '0', '26');
INSERT INTO `dishesinfo` VALUES ('59', '香菇青菜', '鲜美无比，营养丰富', '/img/upload/59.jpg', '香菇青菜是一道菜品，制作原料有青菜、香菇、油、盐等。香菇盛出后，用筷子整齐地摆放在青菜上，最后将锅内的汁淋在菜上即可。', '0', '24');
INSERT INTO `dishesinfo` VALUES ('60', '盐焗花螺', '润肺补肾、促进食欲、补充微量元素', '/img/upload/60.jpg', '盐焗花螺，是一道家常菜，制作原料主要有花螺、姜葱。花螺营养丰富，含有丰富的蛋白质、脂肪、碳水化合物、铁、钙、磷、碘、维生素、氨基酸和牛磺酸等多种成分，是一种低热能、高蛋白的食物。', '0', '36');
INSERT INTO `dishesinfo` VALUES ('61', '永州血鸭', '美味、开胃凉血', '/img/upload/61.jpg', '永州血鸭，是湖南永州的一款地方传统名菜。永州血鸭分为多种，有江永，道县，新田、宁远、蓝山、东安、双牌等多个说法。在当地，几乎家家户户都会制作此菜。具有美味、开胃凉血的特点。', '0', '39');
INSERT INTO `dishesinfo` VALUES ('62', '油焖大虾', '味香飘逸、鲜嫩微甜、油润适口', '/img/upload/62.jpg', '油焖大虾是一道湖北菜，属鄂菜系，起源于湖北江汉油田，已传遍世界各地，并根据当地口味进行改良，成为一道名菜。油焖大虾的主要食材是小龙虾，主要烹饪工艺是炒焖。该菜品色泽枣红亮丽、味香飘逸、鲜嫩微甜、油润适口，是著名的美味佳肴。', '0', '49');
INSERT INTO `dishesinfo` VALUES ('63', '鱼香茄子', '其味厚重悠长，余味缭绕，回味无穷', '/img/upload/63.jpg', '鱼香茄子是一道菜品，是四川省传统的特色名菜之一。属于川菜系中比较具有代表性的鱼香味型的名菜。\r\n\r\n鱼香系列的川菜，最主要的辅料郫县豆瓣。主料配以郫县豆瓣加上其他调料烧出来的菜肴，其味厚重悠长，余味缭绕，回味无穷，故称余香。上世纪七十年代之前，餐馆菜单上书写的有“余香茄子”菜名。', '0', '24');
INSERT INTO `dishesinfo` VALUES ('64', '鱼香肉丝', '鱼香酸辣甜', '/img/upload/64.jpg', '鱼香肉丝，是一道汉族特色传统名菜，以鱼香味调味而得名，属于川菜。相传灵感来自泡椒肉丝，民国年间则是由四川籍厨师创制而成。', '0', '20');

-- ----------------------------
-- Table structure for orderdishes
-- ----------------------------
DROP TABLE IF EXISTS `orderdishes`;
CREATE TABLE `orderdishes` (
  `odid` int(11) NOT NULL AUTO_INCREMENT COMMENT '详单编号，主键，自动增长',
  `orderreference` int(11) NOT NULL COMMENT '对应订单编号，外键\r\n',
  `dishes` int(11) NOT NULL COMMENT '对应菜品编号，外键',
  `num` int(11) NOT NULL COMMENT '菜品的数量',
  `status` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`odid`),
  KEY `orderdishes_orderreference` (`orderreference`),
  KEY `orderdishes_dishes` (`dishes`),
  CONSTRAINT `orderdishes_dishes` FOREIGN KEY (`dishes`) REFERENCES `dishesinfo` (`dishesid`),
  CONSTRAINT `orderdishes_orderreference` FOREIGN KEY (`orderreference`) REFERENCES `orderinfo` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdishes
-- ----------------------------
INSERT INTO `orderdishes` VALUES ('1', '1', '1', '2', '1');
INSERT INTO `orderdishes` VALUES ('2', '1', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('3', '2', '2', '3', '1');
INSERT INTO `orderdishes` VALUES ('4', '4', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('5', '4', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('6', '4', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('7', '5', '7', '3', '1');
INSERT INTO `orderdishes` VALUES ('8', '5', '6', '2', '1');
INSERT INTO `orderdishes` VALUES ('9', '5', '5', '2', '1');
INSERT INTO `orderdishes` VALUES ('10', '5', '8', '2', '1');
INSERT INTO `orderdishes` VALUES ('11', '6', '8', '2', '1');
INSERT INTO `orderdishes` VALUES ('12', '6', '7', '2', '1');
INSERT INTO `orderdishes` VALUES ('13', '6', '2', '2', '1');
INSERT INTO `orderdishes` VALUES ('14', '6', '1', '2', '1');
INSERT INTO `orderdishes` VALUES ('15', '7', '8', '2', '1');
INSERT INTO `orderdishes` VALUES ('16', '7', '7', '2', '1');
INSERT INTO `orderdishes` VALUES ('17', '7', '6', '2', '1');
INSERT INTO `orderdishes` VALUES ('18', '7', '5', '2', '1');
INSERT INTO `orderdishes` VALUES ('19', '8', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('20', '8', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('21', '9', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('22', '10', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('23', '10', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('24', '11', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('25', '11', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('26', '11', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('27', '12', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('28', '13', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('29', '14', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('30', '15', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('31', '16', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('32', '16', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('33', '16', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('34', '17', '1', '2', '1');
INSERT INTO `orderdishes` VALUES ('35', '17', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('36', '17', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('37', '18', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('38', '18', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('39', '18', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('40', '19', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('41', '19', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('42', '20', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('43', '20', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('44', '20', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('45', '21', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('46', '21', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('47', '22', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('48', '23', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('49', '24', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('50', '24', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('51', '24', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('52', '25', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('53', '25', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('54', '25', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('55', '26', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('56', '26', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('57', '26', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('58', '27', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('59', '28', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('60', '29', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('61', '30', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('62', '31', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('63', '32', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('64', '33', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('66', '35', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('67', '35', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('68', '35', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('69', '36', '7', '4', '1');
INSERT INTO `orderdishes` VALUES ('70', '37', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('71', '37', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('72', '37', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('73', '38', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('74', '38', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('75', '38', '8', '1', '1');
INSERT INTO `orderdishes` VALUES ('76', '38', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('77', '39', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('78', '39', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('79', '39', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('80', '40', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('81', '40', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('82', '40', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('83', '41', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('84', '41', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('85', '41', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('86', '41', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('87', '42', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('88', '42', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('89', '42', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('90', '43', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('91', '43', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('92', '43', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('93', '43', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('94', '44', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('95', '44', '2', '2', '1');
INSERT INTO `orderdishes` VALUES ('96', '44', '8', '1', '1');
INSERT INTO `orderdishes` VALUES ('97', '44', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('98', '45', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('99', '45', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('100', '45', '1', '1', '1');
INSERT INTO `orderdishes` VALUES ('101', '45', '5', '1', '1');
INSERT INTO `orderdishes` VALUES ('102', '46', '4', '1', '1');
INSERT INTO `orderdishes` VALUES ('103', '46', '3', '1', '1');
INSERT INTO `orderdishes` VALUES ('104', '46', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('105', '46', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('106', '46', '7', '1', '1');
INSERT INTO `orderdishes` VALUES ('107', '46', '70', '1', '1');
INSERT INTO `orderdishes` VALUES ('108', '46', '69', '1', '1');
INSERT INTO `orderdishes` VALUES ('109', '47', '2', '1', '1');
INSERT INTO `orderdishes` VALUES ('110', '47', '6', '1', '1');
INSERT INTO `orderdishes` VALUES ('111', '47', '5', '1', '1');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号，主键，自动增长',
  `orderbegindate` varchar(50) NOT NULL COMMENT '订单开始时间',
  `orderenddate` varchar(50) DEFAULT NULL COMMENT '订单结束时间',
  `waiterid` int(11) NOT NULL COMMENT '订单的点餐员ID，外键',
  `orderstate` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态：0-正在用餐，1-准备结账，2-已经结账，3-免单订单',
  `tableid` int(11) NOT NULL COMMENT '订单应的桌号',
  PRIMARY KEY (`orderid`),
  KEY `orderinfo_waiterid` (`waiterid`),
  KEY `table_tableid` (`tableid`),
  CONSTRAINT `orderinfo_waiterid` FOREIGN KEY (`waiterid`) REFERENCES `userinfo` (`userid`),
  CONSTRAINT `table_tableid` FOREIGN KEY (`tableid`) REFERENCES `tables` (`tableid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('1', '2020-03-01 12:54', '2020-03-01 13:48', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('2', '2020-03-12 18:03', '2020-03-12 19:31', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('4', '2020-05-14 16:49:41', '2020-05-14 10:41', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('5', '2020-05-14 17:23:25', '2020-05-14 10:41', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('6', '2020-05-14 20:41:33', '2020-05-14 10:41', '3', '1', '3');
INSERT INTO `orderinfo` VALUES ('7', '2020-05-14 20:49:14', '2020-05-14 16:18', '3', '1', '4');
INSERT INTO `orderinfo` VALUES ('8', '2020-05-18 10:24:27', '2020-05-18 16:07', '3', '1', '5');
INSERT INTO `orderinfo` VALUES ('9', '2020-05-19 17:29:39', '2020-05-19 10:42', '3', '1', '6');
INSERT INTO `orderinfo` VALUES ('10', '2020-05-20 09:35:44', '2020-05-20 10:42', '3', '1', '7');
INSERT INTO `orderinfo` VALUES ('11', '2020-05-20 09:36:40', '2020-05-20 10:42', '3', '1', '8');
INSERT INTO `orderinfo` VALUES ('12', '2020-05-20 09:42:01', '2020-05-20 10:42', '3', '1', '9');
INSERT INTO `orderinfo` VALUES ('13', '2020-05-1509:53:32', '2020-05-15 10:42', '3', '1', '10');
INSERT INTO `orderinfo` VALUES ('14', '2020-05-1509:56:56', '2020-05-15 10:42', '3', '1', '11');
INSERT INTO `orderinfo` VALUES ('15', '2020-05-1510:31:29', '2020-05-15 10:42', '3', '1', '12');
INSERT INTO `orderinfo` VALUES ('16', '2020-05-1610:39:05', '2020-05-16 10:42', '3', '1', '13');
INSERT INTO `orderinfo` VALUES ('17', '2020-05-20 10:51:13', '2020-05-20 10:57', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('18', '2020-05-13 10:53:07', '2020-05-13 10:57', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('19', '2020-05-13 10:55:19', '2020-05-13 10:57', '3', '1', '3');
INSERT INTO `orderinfo` VALUES ('20', '2020-05-13 10:55:46', '2020-05-13 10:57', '3', '1', '4');
INSERT INTO `orderinfo` VALUES ('21', '2020-05-13 10:58:19', '2020-05-13 11:10', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('22', '2020-05-17 11:09:52', '2020-05-17 11:10', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('23', '2020-05-17 11:10:00', '2020-05-17 11:10', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('24', '2020-05-17 11:11:21', '2020-05-17 14:32', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('25', '2020-05-17 11:11:54', '2020-05-17 17:43', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('26', '2020-05-19 11:12:15', '2020-05-19 17:43', '3', '1', '3');
INSERT INTO `orderinfo` VALUES ('27', '2020-05-19 11:21:05', '2020-05-19 17:43', '3', '1', '4');
INSERT INTO `orderinfo` VALUES ('28', '2020-05-19 11:21:25', '2020-05-19 17:43', '3', '1', '5');
INSERT INTO `orderinfo` VALUES ('29', '2020-05-19 11:24:05', '2020-05-19 17:43', '3', '1', '6');
INSERT INTO `orderinfo` VALUES ('30', '2020-05-15 11:24:28', '2020-05-15 17:43', '3', '1', '7');
INSERT INTO `orderinfo` VALUES ('31', '2020-05-15 11:27:17', '2020-05-15 17:43', '3', '1', '8');
INSERT INTO `orderinfo` VALUES ('32', '2020-05-15 11:28:50', '2020-05-15 14:33', '3', '1', '9');
INSERT INTO `orderinfo` VALUES ('33', '2020-05-15 14:51:09', '2020-05-15 17:43', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('35', '2020-05-18 17:42:07', '2020-05-18 17:43', '3', '1', '10');
INSERT INTO `orderinfo` VALUES ('36', '2020-05-18 17:42:19', '2020-05-18 17:44', '3', '1', '11');
INSERT INTO `orderinfo` VALUES ('37', '2020-05-18 17:42:24', '2020-05-18 17:44', '3', '1', '12');
INSERT INTO `orderinfo` VALUES ('38', '2020-05-16 17:42:31', '2020-05-16 17:44', '3', '1', '13');
INSERT INTO `orderinfo` VALUES ('39', '2020-05-16 17:47:32', '2020-05-16 17:48', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('40', '2020-05-16 17:47:39', '2020-05-16 17:48', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('41', '2020-05-16 17:47:47', '2020-05-16 17:48', '3', '1', '3');
INSERT INTO `orderinfo` VALUES ('42', '2020-05-20 17:47:56', '2020-05-20 17:48', '3', '1', '4');
INSERT INTO `orderinfo` VALUES ('43', '2020-05-20 17:48:03', '2020-05-20 17:48', '3', '1', '5');
INSERT INTO `orderinfo` VALUES ('44', '2020-05-20 17:48:24', '2020-05-20 17:49', '3', '1', '6');
INSERT INTO `orderinfo` VALUES ('45', '2020-05-20 17:48:32', '2020-05-20 17:49', '3', '1', '1');
INSERT INTO `orderinfo` VALUES ('46', '2020-05-20 17:48:47', '2020-05-20 17:49', '3', '1', '2');
INSERT INTO `orderinfo` VALUES ('47', '2020-05-20 17:48:57', '2020-05-20 17:49', '3', '1', '3');

-- ----------------------------
-- Table structure for roleinfo
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号，主键，自动增长',
  `rolename` varchar(32) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------
INSERT INTO `roleinfo` VALUES ('1', '后厨');
INSERT INTO `roleinfo` VALUES ('2', '管理员');
INSERT INTO `roleinfo` VALUES ('3', '点餐员');

-- ----------------------------
-- Table structure for tables
-- ----------------------------
DROP TABLE IF EXISTS `tables`;
CREATE TABLE `tables` (
  `tableid` int(11) NOT NULL AUTO_INCREMENT COMMENT '餐桌编号',
  `tablename` varchar(50) NOT NULL COMMENT '餐桌名字',
  `tablestatus` int(11) NOT NULL DEFAULT '0' COMMENT '餐桌状态：0为未使用，1为正在使用',
  PRIMARY KEY (`tableid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tables
-- ----------------------------
INSERT INTO `tables` VALUES ('1', '春暖花开', '0');
INSERT INTO `tables` VALUES ('2', '合家小桌', '0');
INSERT INTO `tables` VALUES ('3', '暮春三月', '0');
INSERT INTO `tables` VALUES ('4', '江山如画', '0');
INSERT INTO `tables` VALUES ('5', '水天一色', '0');
INSERT INTO `tables` VALUES ('6', '一叶知秋', '0');
INSERT INTO `tables` VALUES ('7', '枯木逢春', '0');
INSERT INTO `tables` VALUES ('8', '流水落花', '0');
INSERT INTO `tables` VALUES ('9', '阳春白雪', '1');
INSERT INTO `tables` VALUES ('10', '松柏后凋', '0');
INSERT INTO `tables` VALUES ('11', '寒花晚节', '0');
INSERT INTO `tables` VALUES ('12', '金风玉露', '0');
INSERT INTO `tables` VALUES ('13', '啼饥号寒', '0');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号，主键，自动增长',
  `useraccount` varchar(20) NOT NULL COMMENT '账号名称',
  `userpass` varchar(32) NOT NULL COMMENT '登录密码',
  `role` int(11) NOT NULL COMMENT '用户的角色ID，外键',
  `locked` int(11) NOT NULL DEFAULT '1' COMMENT '用户是否被锁定：0-未锁定，1锁定',
  `faceimg` varchar(200) NOT NULL COMMENT '用户头像图片名',
  PRIMARY KEY (`userid`),
  KEY `userinfo_role` (`role`),
  CONSTRAINT `userinfo_role` FOREIGN KEY (`role`) REFERENCES `roleinfo` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '2', '2', '2', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('2', '1', '1', '1', '0', '/img/upload/e2044913-9bac-4773-ad7c-d1bff6958983.png');
INSERT INTO `userinfo` VALUES ('3', '3', '3', '3', '0', '/img/upload/4676fe68-b8ea-4191-a157-32d38d2a8582.png');
INSERT INTO `userinfo` VALUES ('4', '4', '4', '3', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('6', '6', '6', '1', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('7', '7', '7', '2', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('8', '8', '8', '3', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('11', '张三', 'a12345', '1', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('12', '王二麻子', 'a12345', '3', '1', '/img/upload/0b772986-d4e0-4585-9477-845d35486a80.png');
INSERT INTO `userinfo` VALUES ('14', '奥利戈啊', 'a123123', '3', '1', '/img/faces/default.jpg');
INSERT INTO `userinfo` VALUES ('15', '顶顶顶', 'a12345', '1', '1', '/img/upload/2ffac10e-912d-4022-92e7-094b2a1953ba.png');
INSERT INTO `userinfo` VALUES ('16', '李四', 'a12345', '3', '1', '/img/upload/055928ec-5ded-460e-82d7-b02e2e8d61be.jpg');
INSERT INTO `userinfo` VALUES ('17', '王五', 'a12345', '3', '1', '/img/upload/d3eaf0e6-122e-4ada-93bd-789aa773cac1.png');
