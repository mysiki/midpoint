/*
 * Copyright (c) 2010-2013 Evolveum
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.evolveum.midpoint.web.component.orgStruct;

import java.util.Set;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.evolveum.midpoint.web.page.admin.users.dto.OrgStructDto;

/**
 * @author mserbak
 */
public class OrgStructPanel extends OptionalTree {
	private NestedTree<NodeDto> tree;

	public OrgStructPanel(String id, IModel<OrgStructDto> model) {
		super(id, model);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);

        response.render(CssHeaderItem.forReference(
                new PackageResourceReference(OrgStructPanel.class, "OrgStructPanel.css")));
        response.render(JavaScriptHeaderItem.forReference(
                new PackageResourceReference(OrgStructPanel.class, "OrgStructPanel.js")));
        response.render(OnDomReadyHeaderItem.forScript("initOrgStruct()"));
    }

	protected AbstractTree<NodeDto> createTree(OrgStructProvider provider, IModel<Set<NodeDto>> state) {
		tree = new NestedTree<NodeDto>("tabletree", provider, state) {

			@Override
			protected Component newContentComponent(String id, IModel<NodeDto> model) {
				return OrgStructPanel.this.newContentComponent(id, model);
			}

			@Override
			public Component newNodeComponent(String id, IModel<NodeDto> model) {
				return OrgStructPanel.this.newNodeComponent(id, model);
			}
		};
		return tree;
	}
}