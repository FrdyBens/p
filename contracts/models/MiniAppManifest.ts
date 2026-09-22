export interface MiniAppManifest {
  id: string; // e.g. "app.pulsy.music"
  name: string;
  version: string;
  requiredCoreVersion: string;
  description: string;
  iconUri: string;
  entryRoute: string;
  permissions: string[];
  capabilities: string[];
  isEnabled: boolean;
}
