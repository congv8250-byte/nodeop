<p align="center"><img src="docs/logo.png" width="160" alt="nodeop"></p>

# nodeop

Mod **Fabric** cho **Minecraft Java 26.2**: thêm lệnh **`/nodeop`** để **nhân bản món đồ đang cầm trên tay**.

| Lệnh | Tác dụng |
|---|---|
| `/nodeop` | Nhân bản thêm 1 bản (nguyên stack đang cầm) |
| `/nodeop 5` | Nhân bản thêm 5 bản (tối đa 64) |

- **Không cần OP:** ai trong thế giới cũng gõ được, kể cả không phải chủ thế giới và không bật cheat.
- **Im lặng:** lệnh không gửi bất kỳ thông báo nào vào chat.
- Người nào gõ lệnh thì người đó nhận đồ nhân bản. Túi đầy thì đồ rơi xuống chân.
- Tay không cầm gì thì lệnh không làm gì.

## Cách dùng với LAN (chơi đơn mở cho bạn bè)
1. Chỉ **người mở thế giới (host)** cần cài mod, cùng Fabric API vào thư mục `mods`.
2. Bạn bè vào qua LAN **không cần cài mod** vẫn gõ được `/nodeop`.
3. Vào thế giới, bấm `Esc` → **Open to LAN** → **Start LAN World**.

> Lệnh vẫn hiện trong danh sách gợi ý khi gõ `/`, và có thể được ghi trong file log của game.
> Chỉ nên dùng trong thế giới riêng của bạn và bạn bè. Đừng cài lên server công cộng của người khác.

## Yêu cầu
Minecraft Java 26.2, Fabric Loader ≥ 0.19.3, Fabric API cho 26.2, Java 25.

## Build bằng GitHub
Đẩy toàn bộ lên GitHub, tab **Actions** → workflow **build** → tải jar ở mục **Artifacts**.

## Giấy phép
MIT
