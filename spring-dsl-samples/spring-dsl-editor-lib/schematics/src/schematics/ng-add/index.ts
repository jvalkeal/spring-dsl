/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import { Rule, SchematicContext, Tree } from '@angular-devkit/schematics';
// import {NodePackageInstallTask, RunSchematicTask} from '@angular-devkit/schematics/tasks';
import { addPackageToPackageJson, getPackageVersionFromPackageJson } from './package-config';
import { Schema } from './schema';
import { springDslEditorVersion, requiredAngularVersionRange } from './version-names';


export default function(options: Schema): Rule {
    return (host: Tree, _context: SchematicContext) => {
        console.log('options', options);
        console.log('springDslEditorVersion', springDslEditorVersion);
        console.log('requiredAngularVersionRange', requiredAngularVersionRange);

        const ngCoreVersionTag = getPackageVersionFromPackageJson(host, '@angular/core');
        console.log('ngCoreVersionTag', ngCoreVersionTag);

        addPackageToPackageJson(host, 'spring-dsl-editor', `~${springDslEditorVersion}`);

        return host;
    };
}
