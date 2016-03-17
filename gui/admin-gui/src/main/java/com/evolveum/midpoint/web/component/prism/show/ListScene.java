/*
 * Copyright (c) 2010-2016 Evolveum
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

package com.evolveum.midpoint.web.component.prism.show;

import com.evolveum.midpoint.model.api.visualizer.Name;
import com.evolveum.midpoint.model.api.visualizer.Scene;
import com.evolveum.midpoint.model.api.visualizer.SceneItem;
import com.evolveum.midpoint.prism.PrismContainerDefinition;
import com.evolveum.midpoint.prism.PrismContainerValue;
import com.evolveum.midpoint.prism.delta.ChangeType;
import com.evolveum.midpoint.prism.delta.ObjectDelta;
import com.evolveum.midpoint.prism.path.ItemPath;
import com.evolveum.midpoint.util.DebugUtil;

import java.util.Collections;
import java.util.List;

/**
 * Artificial implementation of a scene used to hold a list of deltas.
 *
 * @author mederly
 */
public class ListScene implements Scene {

	private String simpleName, displayName;
	private List<? extends Scene> partialScenes;

	public ListScene(List<? extends Scene> partialScenes, String displayName, String simpleName) {
		this.partialScenes = partialScenes;
		this.simpleName = simpleName;
		this.displayName = displayName;
	}

	@Override
	public Name getName() {
		return new Name() {

			@Override
			public String getSimpleName() {
				return simpleName;
			}

			@Override
			public String getDisplayName() {
				return displayName;
			}

			@Override
			public String getId() {
				return null;
			}

			@Override
			public String getDescription() {
				return null;
			}
		};
	}

	@Override
	public ChangeType getChangeType() {
		return null;
	}

	@Override
	public List<? extends Scene> getPartialScenes() {
		return partialScenes;
	}

	@Override
	public List<? extends SceneItem> getItems() {
		return Collections.emptyList();
	}

	@Override
	public boolean isOperational() {
		return false;
	}

	@Override
	public Scene getOwner() {
		return null;
	}

	@Override
	public ItemPath getSourceRelPath() {
		return null;
	}

	@Override
	public ItemPath getSourceAbsPath() {
		return null;
	}

	@Override
	public PrismContainerValue<?> getSourceValue() {
		return null;
	}

	@Override
	public PrismContainerDefinition<?> getSourceDefinition() {
		return null;
	}

	@Override
	public ObjectDelta<?> getSourceDelta() {
		return null;
	}

	@Override
	public String debugDump() {
		return debugDump(0);
	}

	@Override
	public String debugDump(int indent) {
		return DebugUtil.debugDump(partialScenes, indent);
	}
}
