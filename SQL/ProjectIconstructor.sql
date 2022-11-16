SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `ProjectI` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ProjectI`;

DROP TABLE IF EXISTS `Questions`;
CREATE TABLE `Questions` (
  `QID` int(11) NOT NULL,
  `Question` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `RightAnswer` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `WrongAnswer1` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `WrongAnswer2` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `WrongAnswer3` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `QLevel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `Questions` (`QID`, `Question`, `RightAnswer`, `WrongAnswer1`, `WrongAnswer2`, `WrongAnswer3`, `QLevel`) VALUES
(1, 'Đâu không phải động vật có sừng', 'Sư Tử', 'Tuần Lộc', 'Linh Dương', 'Trâu', 5),
(2, 'Trong câu chuyện cổ tích, phù thủy đi lại bằng phương tiện nào', 'Cưỡi chổi', 'Cưỡi Thảm bay', 'Cưỡi mây', 'Cưỡi tuần lộc', 15),
(3, 'Loài chim nào sau đây có thể bắt chước tiếng người', 'Vẹt', 'Chim Sẻ', 'Quạ', 'Chích Bông', 5),
(4, 'Thành ngữ nào sau đây  nói về việc chịu đựng gian nan, vất vả để làm việc lớn', 'Nằm gai nếm mật', 'Lưỡi sắc hơn gươm', 'Mật ngọt chết ruồi', 'Tre non dễ uốn', 5),
(5, 'Đâu là tên một loại đàn cổ ở Tây Nguyên', 'Đá', 'Đất', 'Cát', 'Sỏi', 15),
(6, 'Cho đến nay từ Tiếng Việt nào chưa nằm trong từ điển Oxford', 'Nem', 'Bánh mỳ', 'Áo dài', 'Phở', 10),
(7, 'Ca phẫu thuật thành công nào tách rời cặp song sinh dính liền vào nhau nằm trong 10 sự kiện KH-CN Việt Nam nổi bật năm 2020', 'Trúc Nhi- Diệu Nhi', 'Phi Long- Phi Phụng', 'Việt-Đức', 'Cu- Cò', 15),
(8, 'Ngày 19-11 hằng năm là ngày gì', 'Ngày Toilet thế giới', 'Ngày môi trường thế giới', 'Ngày Nước thế giới', 'Ngày quốc tế hạnh phúc', 15),
(9, 'Logo của CLB Bóng đá nào có hình con Sư Tử', 'Chelsea', 'Manchester United', 'Arsenal', 'Liverpool', 10),
(10, 'Trong Lễ Hiển Linh(Epiphany) Tổng thống Nga Putin đã thực hiện nghi thức gì ?', 'Ngâm mình dưới hồ băng', 'Đi trên than nóng', 'Cười ngựa đi săn', 'Câu cá trên băng', 15),
(11, 'Đài thiên văn ALMA được đặt tại quốc gia Nam Mỹ nào?', 'Chile', 'Brazil', 'Argentina', 'Uruguay', 15),
(12, 'Sazae-san là bộ phim dài nhất thế giới thuộc thể loại nào?', 'Hoạt Hình ', 'Trinh thám', 'Hành động', 'Kinh dị', 10),
(13, 'Giải thưởng Giáo viên toàn cầu 2020 thuộc về người nước nào', 'Ấn Độ', 'Việt Nam', 'Brazil', 'Nam Phi', 10),
(14, 'Tên viết tắt Tiếng Anh của Liên Hợp Quốc là gì ?', 'UN', 'WB', 'EU', 'EM', 15),
(15, 'Bài hát nào là ca khúc chính thức của World Cup 2018', 'Live it up', 'Waka Waka', 'We Are One', 'The Cup of Life', 5),
(16, 'Bài thơ \" Đồng Chí\" được nhà thơ Chính Hữu sáng tác khi tham gia chiến dịch nào?', 'Việt Bắc', 'Hồ Chí Minh', 'Điện Biên Phủ', 'Tây Nguyên', 15),
(17, 'Bếp dã chiến \"Hoàng Cầm\" phục vụ quân đội ra đời ở chiến dịch nào trong kháng chiến chống Pháp', 'Hòa Bình', 'Biên giới', 'Điện Biên Phủ', 'Tây Bắc', 10),
(18, 'Các vua Hùng đặt quốc hiệu nước ta là gì ?', 'Văn Lang', 'Đại Việt', 'Vạn Xuân', 'Âu Lạc', 10),
(19, 'Hệ thống đô thị ở Việt Nam được phân thành mấy loại?', '5', '4', '3', '6', 5),
(20, 'Trên mặt thoáng chất lỏng có hai quá trình ngược nhau đó là sự bay hơi và gì?', 'Sự ngưng tụ', 'Sư thăng hoa', 'Sự kết tủa', 'Sự đông đặc', 10),
(21, 'Kim loại nào sau đây là kim loại Kiềm thổ', 'Bari', 'Natri', 'Đồng', 'Sắt', 15),
(22, 'Trong hệ SI, đơn vị của Hiệu Điện Thế là:', 'V', 'F', 'A', 'V/m', 15),
(23, 'Chương trình khai thác thuộc địa lần thứ hai của thực dân Pháp bắt đầu vào năm nào?', '1919', '1920', ' 1914', '1918', 10),
(24, 'Thủ đoạn thâm độc nhất về chính trị của thực dân Pháp để nô dịch lâu dài nhân dân ta là gì?', 'Thực hiện chích sách “chia để trị”', 'Tăng cường khủng bố, đàn áp nhân dân.', 'Cấu kết với vua quan Nam triều để đàn áp nhân dân.', 'Thâu tóm quyền hành trong tay người Pháp.', 15),
(25, 'Nguyễn Ái Quốc ra đi tìm đường cứu nước vào ngày tháng năm nào?', '1911-05-06 00:00:00', '1911-06-05 00:00:00', '7/5/1911 ', '1911-08-05 00:00:00', 10),
(26, 'Tổng bí thư đầu tiên của Đảng ta là ai?', 'Trần Phú', 'Nguyễn Ái Quốc', 'Lê Duẩn', 'Trường Chinh', 5),
(27, 'Con người ta khát nước vì:', 'Lượng nước giảm, nồng độ muối tăng', 'Nồng độ muối giảm', 'Lượng nước giảm, nồng độ muối giảm', 'Lượng nước giảm', 5),
(28, 'Giác quan nào bị tổn thương nặng nhất khi một người bị sét đánh?', 'Thính giác.', 'Xúc giác.', 'Thị giác.', 'Vị giác.', 10),
(29, 'Bộ phận nào trên cơ thể người không có cơ?', 'Tai', 'Mắt', 'Cổ', 'Lưỡi', 10),
(30, 'Trong 4 yếu tố sau đây, yếu tố nào ảnh hưởng đến ba yếu tố còn lại?', 'Ánh Sáng', 'Nhiệt Độ', 'Gió', 'Độ Ẩm', 10),
(31, 'Ở Việt Nam có 5% số người sử dụng điện thoại không có tên trong danh bạ điện thoại. Nếu ta lấy ngẫu nhiên 100 người trong danh bạ thì trung bình sẽ có bao nhiêu người không có số điện thoại', '0', '0.25', '0.5', '1', 10),
(32, 'Cái gì đánh cha, đánh má, đánh anh, đánh chị, đánh em?', 'Cái Bàn chải đánh răng', 'Cái gậy', 'Cái Trống', 'Cái Chổi', 10),
(33, 'A gọi B bằng bác, B gọi C là ông nội, C gọi D là cậu, D kêu E là dì, E kêu F là chú, F gọi Z là con. Hỏi A gọi Z bằng gì?', 'Mồm', 'Chú', 'Bác ', 'Cậu', 10),
(34, 'Kể từ khi thành lập vào năm 1863, Ủy ban Chữ thập đỏ quốc tế đã đoạt giải Nobel bao nhiêu lần', '3', '4', '2', '1', 5),
(35, 'Liên Xô chính thức được thành lập vào năm nào', '1922', '1925', '1924', '1923', 15),
(36, 'Da gấu Bắc Cực có màu gì?', 'Đen', 'Hồng', 'Cam ', 'Trắng', 5),
(37, 'Có bao nhiêu chữ cái được sử dụng trong phiên bản Tiếng Anh hiện tại', '26', '22', '28', '24', 15),
(38, 'Trong truyện tranh của hãng DC, tên thật của Batman là gì', 'Bruce Wayne', 'Thomas Wayne', 'Arthur Fleck', 'Michael Jackson', 15),
(39, 'Trong thần thoại Hy Lạp, ai là cha của Hermes', 'Zeus', 'Ares', 'Apollo', 'Poseidon', 15),
(40, 'Tôn hiệu của vị hoàng đế cuối cùng của triều đại nhà Thanh của Trung Quốc là gì?', 'Tuyên Thống', 'Hàm Phong', 'Đồng Trị', 'Quanh Tự', 5),
(41, 'Nữ thần trái đất trong thần thoại Hy Lạp cổ đại là ai?', 'Gaea', 'Chaos', 'Eros', 'Nyx', 10);

DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `UID` int(11) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Score` int(11) DEFAULT NULL,
  `Date` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `Users` (`UID`, `Name`, `Score`, `Date`) VALUES
(1, 'BHTU', NULL, '2022-10-31 13:12:32'),
(2, 'npp', NULL, '2022-10-31 17:31:36'),
(3, 'acrean', NULL, '2022-11-01 17:57:10'),
(4, 'thisis4', NULL, '2022-11-01 18:02:11'),
(5, 'this is 5', NULL, '2022-11-01 18:03:08');


ALTER TABLE `Questions`
  ADD PRIMARY KEY (`QID`),
  ADD UNIQUE KEY `U_Question` (`Question`,`RightAnswer`) USING HASH;

ALTER TABLE `Users`
  ADD PRIMARY KEY (`UID`),
  ADD UNIQUE KEY `u_Name` (`Name`),
  ADD KEY `ixHighScore` (`Score`);


ALTER TABLE `Questions`
  MODIFY `QID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

ALTER TABLE `Users`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
