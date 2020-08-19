alter procedure sp_LocPhong
	@TuKhoa nvarchar(100),
	@LoaiPhong nvarchar(50),
	@MinGia money,
	@MaxGia money,
	@TinhTrang nvarchar(50)
as
begin 
	if(@MaxGia = 0) set @MaxGia = (select max(giaPhong) from LoaiPhong)
	if(@TinhTrang = '') set @TinhTrang = '%%'
	if(@TuKhoa = '') set @TuKhoa = '%%'
	else set @TuKhoa = '%' +@TuKhoa+'%'
	if(@LoaiPhong = '') set @LoaiPhong = '%%'

			select * from Phong join LoaiPhong
			on Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
			where MaPhong like @TuKhoa and 
			Phong.MaTinhTrang like @TinhTrang and
			Phong.MaLoaiPhong like @LoaiPhong and
			LoaiPhong.GiaPhong >= @MinGia and LoaiPhong.GiaPhong <=@MaxGia
			
end

go
alter procedure sp_locKhachHang
	@TuKhoa nvarchar(100),
	@maLoaiKhachHang nvarchar(5),
	@MinNamSinh int,
	@MaxNamSinh int,
	@gioiTinh nvarchar(5)
as
begin 
	if(@MinNamSinh = 0)	set @MinNamSinh = (select max(YEAR(NgaySinh)) from KhachHang)
	if(@MaxNamSinh = 0) set @MaxNamSinh = (select min(YEAR(NgaySinh)) from KhachHang)
	if(@gioiTinh = '') set @gioiTinh = '%%'
	if(@gioiTinh = 'nam') set @gioiTinh = '%1%'
	if(@gioiTinh = 'nu') set @gioiTinh = '%0%'
	if(@TuKhoa = '') set @TuKhoa = '%%'
	else set @TuKhoa = N'%' +@TuKhoa+'%'
	if(@maLoaiKhachHang = '') set @maLoaiKhachHang = '%%'


	select * from KhachHang 
	where CMND like @TuKhoa or TenKhachHang like @TuKhoa or SDT like @TuKhoa or DiaChi like @TuKhoa and
	YEAR(NgaySinh) <= @MaxNamSinh and YEAR(NgaySinh) >= @MinNamSinh and 
	KhachHang.MaLoaiKhachHang like @maLoaiKhachHang and 
	GioiTinh like @gioiTinh
	
			
			
end




