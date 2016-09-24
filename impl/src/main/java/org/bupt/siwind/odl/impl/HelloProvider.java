/*
 * Copyright © 2016 www.bupt.edu.cn and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.bupt.siwind.odl.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hello.rev150105.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloProvider {

	private static final Logger LOG = LoggerFactory.getLogger(HelloProvider.class);

	private final RpcProviderRegistry rpcRegistry;
	private final DataBroker dataBroker;

	private RpcRegistration<HelloService> helloService = null;

	public HelloProvider(final DataBroker dataBroker, RpcProviderRegistry rpcRegistry) {
		this.dataBroker = dataBroker;
		this.rpcRegistry = rpcRegistry;
	}

	/**
	 * Method called when the blueprint container is created.
	 */
	public void init() {
		LOG.info("HelloProvider Session Initiated");
		helloService = rpcRegistry.addRpcImplementation(HelloService.class, new HelloImpl());
	}

	/**
	 * Method called when the blueprint container is destroyed.
	 */
	public void close() {
		LOG.info("HelloProvider Closed");
		if (helloService != null) {
			helloService.close();
		}
	}
}

// Following is previous method
// import
// org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
// import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
// import
// org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
// import
// org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hello.rev150105.HelloService;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// public class HelloProvider implements BindingAwareProvider, AutoCloseable {
//
// private static final Logger LOG =
// LoggerFactory.getLogger(HelloProvider.class);
//
// private RpcRegistration<HelloService> helloService = null;
//
// @Override
// public void onSessionInitiated(ProviderContext session) {
// LOG.info("HelloProvider Session Initiated");
// helloService = session.addRpcImplementation(HelloService.class, new
// HelloImpl());
// }
//
// @Override
// public void close() throws Exception {
// LOG.info("HelloProvider Closed");
// if (helloService != null) {
// helloService.close();
// }
// }
//
// }