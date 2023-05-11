package com.example.quick_cheque.di.modules

import android.content.SharedPreferences
import com.example.quick_cheque.data.local.dao.RoomDao
import com.example.quick_cheque.data.remote.QuickChequeApi
import com.example.quick_cheque.data.repository.AuthenticationRepositoryImpl
import com.example.quick_cheque.data.repository.RoomRepositoryImpl
import com.example.quick_cheque.domain.repository.AuthenticationRepository
import com.example.quick_cheque.domain.repository.RoomRepository
import com.example.quick_cheque.domain.use_case.ValidateLoginUseCase
import com.example.quick_cheque.domain.use_case.ValidatePasswordUseCase
import com.example.quick_cheque.domain.use_case.ValidateRepeatedPasswordUseCase
import com.example.quick_cheque.domain.use_case.ValidateUsername
import com.example.quick_cheque.presentation.screen.auth_pages_fragment.AuthorizationViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideValidateUsernameUseCase(): ValidateUsername {
        return ValidateUsername()
    }

    @Provides
    fun provideValidateLoginUseCase(): ValidateLoginUseCase {
        return ValidateLoginUseCase()
    }

    @Provides
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase {
        return ValidatePasswordUseCase()
    }

    @Provides
    fun provideValidateRepeatedPasswordUseCase(): ValidateRepeatedPasswordUseCase {
        return ValidateRepeatedPasswordUseCase()
    }

    @Provides
    fun provideRegisterViewModelFactory(
        authenticationRepository: AuthenticationRepository,
        validateUsername: ValidateUsername,
        validateEmail: ValidateLoginUseCase,
        validatePassword: ValidatePasswordUseCase,
        validateRepeatedPassword: ValidateRepeatedPasswordUseCase,
    ): AuthorizationViewModelFactory {
        return AuthorizationViewModelFactory(
            authenticationRepository,
            validateUsername,
            validateEmail,
            validatePassword,
            validateRepeatedPassword,
        )
    }
}