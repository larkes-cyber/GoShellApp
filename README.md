# Go Shell

Go shell app is application that helps you to controll your home.

## Features:
- Multi-module architecture
- JWT Authorization
- Сaching
- Pagination
- Modal view
- Fullstack app

## Multi-module architecture

### Overview
![image](https://github.com/larkes-cyber/GoShellApp/assets/79082708/37fc5756-f7b6-4dff-9495-9baa62ba5a1a)

### Modules:
- Core [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="430" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/306dc143-4d63-4997-b723-9387c619c5f5">

#

- Core-Utils [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="320" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/e337c0f6-c45f-4cd6-b996-f1c2dad8304d">

#
  
- Compose-Utils [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="264" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/b040a8da-6494-4789-8490-740d035431a1">

#

- Root-Compose [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="286" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/a495c860-4569-400a-8bed-44214ead0eba">

#

- Root-Core [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="268" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/c3b545ec-9ff7-46e5-9e28-453976cd5c7c">

#
  
- Root-Ios [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="559" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/94199754-b855-44cf-bbb2-91a6d82443ba">

#
 
- Auth [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="371" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/4858bce5-bd87-4c76-835d-f72a34d68073">

#

- Device [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="366" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/66a82fc4-b860-42a2-9aaf-9037123cd0c8">

#
  
- Main [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="292" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/dcb564dc-2c7f-4b93-9ac4-bf1194a108e8">

#
  
- Profile [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="321" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/366faa52-5338-4f06-b216-4b2f148c6a23">

#

- Room [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/core)
<img width="412" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/51ef7e29-c816-4554-a937-250063b14229">

## JWT Authorization

### Getting token [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/auth/data/src/commonMain/kotlin/ktor/AuthKtorDataSourceImpl.kt)
<img width="590" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/e1921c4a-f915-4ec7-93ca-2aa8a4c69de6">


### Saving token [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/auth/data/src/commonMain/kotlin/settings/AuthSettingDataSourceImpl.kt)
<img width="702" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/d5dbf000-4c21-481e-a8f0-8356a56b06c8">

### Pinning token
<img width="514" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/0fd9008a-be2b-4fec-ac3c-61371beb5d24">

## Сaching

### Addind room caching mechanism [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/auth/data/src/commonMain/kotlin/settings/AuthSettingDataSourceImpl.kt)
<img width="587" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/5de4b7a3-35a6-452c-8c84-992b70c8a965">

### Fetching rooms caching mechanism [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/room/data/src/commonMain/kotlin/RoomRepositoryImpl.kt)
<img width="567" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/04a67e7e-2474-456c-9a79-704fe14705f1">

### Room caching source [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/room/data/src/commonMain/kotlin/sqldelight/RoomSqlDelightDataSourceImpl.kt)
<img width="573" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/f313e9f5-33c7-49b8-a9ce-c93fb0ee8b99">


### Room devices caching mechanism [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/device/data/src/commonMain/kotlin/DeviceRepositoryImpl.kt)
<img width="898" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/8abef1e3-7fec-481c-92a4-c2254e058116">

## Pagination

### Screencast
https://github.com/larkes-cyber/GoShellApp/assets/79082708/85136066-41d0-4b72-8618-c1c4a474482c

### Room pagination mechanism [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/room/data/src/commonMain/kotlin/RoomRepositoryImpl.kt)
<img width="590" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/94788b7c-6e94-4995-80a3-a02ab7afde4d">

### Room pagination mechanism [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/room/data/src/commonMain/kotlin/RoomRepositoryImpl.kt)
<img width="590" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/94788b7c-6e94-4995-80a3-a02ab7afde4d">

### Fetching room view model [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/main/presentation/src/commonMain/kotlin/rooms/RoomsViewModel.kt)
<img width="755" alt="image" src="https://github.com/larkes-cyber/GoShellApp/assets/79082708/ffd6c32d-15bd-47ab-a3d1-9a6925374a44">

## Modal view

### Screencast [link](https://github.com/larkes-cyber/GoShellApp/tree/main/common/room/compose/src/androidMain/kotlin/modal/add_room)
https://github.com/larkes-cyber/GoShellApp/assets/79082708/8a1dc0fb-8e9c-447f-aac8-47ebc8cc707a

## Backend [link](https://github.com/larkes-cyber/GoShellBackend/tree/main) 
## How to start
- Launch the server
- Clone repository
- Paste your ipv4 [link](https://github.com/larkes-cyber/GoShellApp/blob/main/common/core/src/commonMain/kotlin/ktor/KtorModule.kt)
- Enjoy the app !




