import { Description } from "./map-string";

export interface Image {
    id?: string;
    title: string;
    alt: Description;
    extension: string;
    url: string;
    imageBase64: string;
    fileStatus: string;
    purposeOfUses: [string];
    placesOfUsed: [number];
}