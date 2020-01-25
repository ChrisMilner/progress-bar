package com.chrisdmilner.progressbar;

import java.util.Iterator;

import javax.annotation.Nonnull;

import com.chrisdmilner.progressbar.style.ProgressBarStyle;
import com.chrisdmilner.progressbar.style.ProgressBarStyleFactory;
import com.google.common.collect.Iterators;

public class ProgressBarIterable<K> implements Iterable<K> {
    private final Iterable<K> iterable;
    private final ProgressBarStyle style;

    ProgressBarIterable(Iterable<K> iterable, ProgressBarStyle style) {
        this.iterable = iterable;
        this.style = style;
    }

    public ProgressBarIterable(Iterable<K> iterable) {
        this(iterable, ProgressBarStyleFactory.getDefaultStyle());
    }

    @Override
    @Nonnull
    public Iterator<K> iterator() {
        return new ProgressBarIterator<>(iterable.iterator(), Iterators.size(iterable.iterator()), style);
    }

    static class ProgressBarIterator<K> implements Iterator<K> {

        private final Iterator<K> iterator;
        private final ProgressBar bar;

        ProgressBarIterator(Iterator<K> iterator, int size, ProgressBarStyle style) {
            this.iterator = iterator;
            this.bar = new ProgressBar(size, style);
            this.bar.start();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public K next() {
            bar.step();
            return iterator.next();
        }
    }
}
