package com.designpatterns.behavioral.observed;
import java.util.ArrayList;
import java.util.List;

public class Youtubechannel implements Channel {
	private List<Subscribers> subscribers;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();

	public Youtubechannel() {
		subscribers = new ArrayList<Subscribers>();
	}

	@Override
	public void notifie() {
		List<Subscribers> subscriber = null;
		synchronized (MUTEX) {
			if (!changed)
				return;
			subscriber = new ArrayList<>(this.subscribers);
			this.changed = false;
		}
		for (Subscribers obj : subscriber) {
			obj.update();
		}
	}

	public void postmsg(String msg) {
		System.out.println("Message Posted to channel:" + msg);
		this.message = msg;
		this.changed = true;
		notifie();
	}

	@Override
	public void subscribe(Subscribers obj) {
		// TODO Auto-generated method stub
		if (obj == null)
			throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
			if (!subscribers.contains(obj))
				subscribers.add(obj);
		}
	}

	@Override
	public void unsubscribe(Subscribers obj) {
		synchronized (MUTEX) {
			subscribers.remove(obj);
		}

	}

	@Override
	public Object getChannelupdate(Subscribers obj) {
		// TODO Auto-generated method stub
		return this.message;
	}

}
