package xdroid.eventbus;

import android.content.Intent;
import android.os.Bundle;

import xdroid.app.FragmentExt;

public class EventBusFragment extends FragmentExt implements EventDispatcherOwner {
    private final Options mOptions;

    public EventBusFragment() {
        mOptions = new Options();
    }

    @Override
    public int getEventDispatcherXmlId() {
        return 0;
    }

    @Override
    public Options getEventDispatcherOptions() {
        return mOptions;
    }

    @Override
    public Bundle extractInitialEvent() {
        return EventBus.extract(getArguments());
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        EventDispatcherHelper.onCreate(this, state);
    }

    @Override
    public void onResume() {
        super.onResume();

        EventDispatcherHelper.onResume(this);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);

        EventDispatcherHelper.onSaveInstanceState(this, state);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (EventDispatcherHelper.onActivityResult(this, requestCode, resultCode, data)) {
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
