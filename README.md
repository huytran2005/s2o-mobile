com.yourcompany.s2o
│
├── core/                     # Dùng chung toàn app
│   ├── network/
│   │   ├── ApiConfig.kt      # BASE_URL
│   │   ├── ApiClient.kt      # Retrofit
│   │   ├── AuthInterceptor.kt# Gắn token (nếu có)
│   │   └── ApiResult.kt      # Success / Error
│   │
│   └── utils/
│       └── Constants.kt
│
├── data/                     # MODEL
│   ├── remote/               # GỌI API
│   │   ├── auth/
│   │   │   ├── AuthApi.kt
│   │   │   └── dto/
│   │   │       ├── LoginRequest.kt
│   │   │       └── LoginResponse.kt
│   │   │
│   │   ├── product/
│   │   │   ├── ProductApi.kt
│   │   │   └── dto/
│   │   │       └── ProductResponse.kt
│   │   │
│   │   └── order/
│   │       ├── OrderApi.kt
│   │       └── dto/
│   │           └── OrderRequest.kt
│   │
│   ├── repository/           # MODEL trong MVVM
│   │   ├── AuthRepository.kt
│   │   ├── ProductRepository.kt
│   │   └── OrderRepository.kt
│   │
│   └── mapper/               # DTO → UI Model
│       └── ProductMapper.kt
│
├── ui/                       # VIEW + VIEWMODEL
│   ├── auth/
│   │   ├── LoginScreen.kt
│   │   ├── AuthViewModel.kt
│   │   └── AuthState.kt
│   │
│   ├── product/
│   │   ├── ProductScreen.kt
│   │   ├── ProductViewModel.kt
│   │   └── ProductState.kt
│   │
│   ├── order/
│   │   ├── OrderScreen.kt
│   │   ├── OrderViewModel.kt
│   │   └── OrderState.kt
│   │
│   └── theme/
│
├── navigation/
│   └── AppNavGraph.kt
│
└── MainActivity.kt
