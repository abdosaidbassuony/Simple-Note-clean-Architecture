package com.example.cleanarchproject.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchproject.utils.SingleLiveEvent
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel:ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _loadingState = SingleLiveEvent<Boolean>()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    private val _showLoginDialog = SingleLiveEvent<Boolean>()
    val showLoginDialog: LiveData<Boolean>
        get() = _showLoginDialog

    private val successEvent = SingleLiveEvent<String>()
    val errorEvent = SingleLiveEvent<String>()

    override fun onCleared() {
        compositeDisposable.dispose()
    }

    protected fun Disposable.addToDisposableBag() {
        compositeDisposable.add(this)
    }

    private fun showLoading() {
        _loadingState.value = true
    }

    private fun hideLoading() {
        _loadingState.value = false
    }

    protected fun showSuccessMessage(message: String) {
        successEvent.value = message
    }

    // Reactive UI extensions
    protected fun <T> Single<T>.applyLoadingState(): Single<T> =
        this.observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .doAfterTerminate { hideLoading() }

    protected fun Completable.applyLoadingState(): Completable =
        this.observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .doAfterTerminate { hideLoading() }

    protected fun <T> Maybe<T>.applyLoadingState(): Maybe<T> =
        this.observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .doAfterTerminate { hideLoading() }


    protected fun showLoginDialog() {
        _showLoginDialog.value = true
    }


}