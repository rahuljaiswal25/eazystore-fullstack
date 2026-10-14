import React from "react";
import PageTitle from "./PageTitle";

export default function PageHeading({ title, children }) {
  return (
    <div className="text-center max-w-[576px] mx-auto px-4 py-0">
      <PageTitle title={title} />

      <p className="font-primary leading-6 text-gray-600 dark:text-lighter mt-2">
        {children}
      </p>
    </div>
  );
}
