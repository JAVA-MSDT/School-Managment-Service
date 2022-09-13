export interface Image {
    id?: string;
    title: string;
    alt: string;
    extension: string;
    url: string;
    imageBase64: string;
    fileStatus: string;
    purposeOfUses: [string];
    placesOfUsed: [number];
}