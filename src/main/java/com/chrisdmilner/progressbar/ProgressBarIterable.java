package com.chrisdmilner.progressbar;

import com.chrisdmilner.progressbar.style.ProgressBarRenderer;
import com.chrisdmilner.progressbar.style.ProgressBarRendererFactory;
import com.google.common.collect.Iterators;

import javax.annotation.Nonnull;
import java.util.Iterator;

public class ProgressBarIterable<K> implements Iterable<K> {
    private final Iterable<K> iterable;
    private final ProgressBarRenderer style;

    ProgressBarIterable(Iterable<K> iterable, ProgressBarRenderer style) {
        this.iterable = iterable;
        this.style = style;
    }

    ProgressBarIterable(Iterable<K> iterable) {
        this(iterable, ProgressBarRendererFactory.getDefaultStyle());
    }

    @Override
    @Nonnull
    public Iterator<K> iterator() {
        return new ProgressBarIterator<>(iterable.iterator(), Iterators.size(iterable.iterator()), style);
    }

    static class ProgressBarIterator<K> implements Iterator<K> {

        private final Iterator<K> iterator;
        private final ProgressBar bar;

        ProgressBarIterator(Iterator<K> iterator, int size, ProgressBarRenderer style) {
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
