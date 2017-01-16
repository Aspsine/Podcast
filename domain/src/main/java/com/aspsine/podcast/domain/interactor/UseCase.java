package com.aspsine.podcast.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by aspsine on 16/11/5.
 */

public abstract class UseCase<T> {

    private final Scheduler mSubscribeOnScheduler;

    private final Scheduler mObserveOnScheduler;

    private Subscription mSubscription;

    public UseCase(Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        this.mSubscribeOnScheduler = subscribeOnScheduler;
        this.mObserveOnScheduler = observeOnScheduler;
    }

    public void execute(Subscriber<T> subscriber) {
        mSubscription = buildUseCaseObservable()
                .subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserveOnScheduler)
                .subscribe(subscriber);
    }

    public void unSubscribe() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    public abstract Observable<T> buildUseCaseObservable();
}
