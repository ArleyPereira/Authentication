package com.example.authentication.domain.usecase.auth

import com.example.authentication.data.repository.auth.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class RecoverUseCase @Inject constructor(
    private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl
) {

    suspend operator fun invoke(email: String) {
        return authFirebaseDataSourceImpl.recover(email)
    }

}