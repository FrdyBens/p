import { NotificationType } from "../enums/NotificationType";

export interface NotificationAction {
  actionId: string;
  label: string;
  payloadJson?: string | null;
}

export interface Notification {
  id: string; // notif_01j7b...
  userId: string;
  type: NotificationType;
  title: string;
  body: string;
  isRead: boolean;
  targetRoute?: string | null;
  actions: NotificationAction[];
  createdAt: string; // ISO-8601 UTC
}
